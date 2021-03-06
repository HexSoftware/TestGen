package testtool.models.questiondb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import testtool.views.questiondb.QuestionDBFrame;

/**
 * The Question Bank is the main focus of the question database, and is the view
 * from section 2.3. It displays the list of questions, which is represented by
 * the questions component. It also handles the management of these questions,
 * which involves adding, editing, removing, search and filter. 
 * 
 * @author Neil Nordhof (nnordhof@calpoly.edu), RJ Almada (rjalmada@calpoly.edu)
 * @version 12jun14
 */
public class QuestionDatabank {
	public ArrayList<QuestionEntry> questions;
	public ArrayList<QuestionEntry> filteredQs;
	public ArrayList<QuestionEntry> testQs;
	public ArrayList<Filter> filters;
	public QuestionEntry newestQ;
	public Filter newestF;
	public QuestionDBFrame qdbf;

	public QuestionDatabank(QuestionDBFrame qdbf, boolean rff, ArrayList<Question> tqs) {
		//rff = read from file. if false, will create an empty databank. 
		//otherwise, questions will be loaded form QustionDB.txt
		questions = new ArrayList<QuestionEntry>();
		filteredQs = new ArrayList<QuestionEntry>();
		testQs = new ArrayList<QuestionEntry>();
		filters = new ArrayList<Filter>();
		this.qdbf = qdbf;
		
		if(tqs == null) {
			tqs = new ArrayList<Question>();
		}
		
		if (rff) {
			try {
				loadDatabase(tqs);
			} catch (FileNotFoundException e) {
				System.out.println("No database found. Creating Empty Database");
			}
		}
	}

	/**
	 * add takes a question from the add a question dialog, and adds it into the
	 * question list.
	 */
	/*
	 * @ requires (* That question q is a vaild question.); ensures (* That a
	 * valid question is added to the databank.);
	 * 
	 * @
	 */
	public void add(Question q) {
		ArrayList<Filter> qFils = new ArrayList<Filter>();
		for (Filter f : filters) {
			if(checkFiltered(f, q)) {
				qFils.add(f);
			}
		}
		QuestionEntry qe = new QuestionEntry(q, qFils);
		newestQ = qe;		
		if (qFils.isEmpty())
			questions.add(qe);
		else
			filteredQs.add(qe);
		System.out.println("In QuestionDatabank.add");
	}

	/**
	 * edit allows changes to be applied to an existing Question q in the
	 * question list.
	 * 
	 * @param q
	 *            - question to edit
	 */
	/*
	 * @ requires (* That a single question in the databank is selected, and
	 * that Question q is a valid question that is in the databank.); ensures (*
	 * That only one valid question is edited.);
	 * 
	 * @
	 */
	public void edit(int i, Question q) {
		ArrayList<Filter> qFils = new ArrayList<Filter>();
		for (Filter f : filters) {
			if(checkFiltered(f, q)) {
				qFils.add(f);
			}
		}
		QuestionEntry qe = new QuestionEntry(q, qFils);
		newestQ = qe;		
		if (qFils.isEmpty())
			questions.set(i, qe);
		else
			filteredQs.set(i, qe);
		System.out.println("In QuestionDatabank.edit");
	}

	/**
	 * remove takes a collection of Questions qs and removes them from the
	 * question database. If the question are in one or more tests, it will be
	 * replaced with a dummy question letting the instructor know that the
	 * question had been removed from the database
	 */
	/*
	 * @ requires (* That a one or more questions in the databank are selected.
	 * Also that all questions in qs are valid questions and are in the databank
	 * also.); ensures (* That some valid questions are removed.);
	 * 
	 * @
	 */
	public void remove(int[] indices) {
		for (int i = indices.length-1; i >= 0; i--) {
			questions.remove(indices[i]);
		}
		System.out.println("In QuestionDatabank.remove");
	}

	/**
	 * search uses the String keyword to find any questions that match keyword.
	 * This match can be in any category, and only searches through questions
	 * that have not been filtered out. search differs from filter due to filter
	 * only being able to filter by a full categorical symbol, while search can
	 * use partial words on any category. A blank search shows all questions
	 * (clears the search)
	 * 
	 * @param keyword
	 *            - keyword to search for
	 */
	/*
	 * @ requires (* That keyword has no whitespace characters aside from space.
	 * ensures (* That the seacrh won't be searching for newlines or tabs.);
	 * 
	 * @
	 */
	public void search(String keyword) {
		System.out.println("In QuestionDatabank.search");
	}

	/**
	 * filter applies a Filter fil to the databank. This will only show
	 * questions who match the full keyword in the filtered category. Multiple
	 * filters can be applied, and are removed using unfilter. filter differs
	 * from search due to filter only being able to filter by a full categorical
	 * symbol, while search can use partial words on any category.
	 * 
	 * @param fil
	 *            - filter to search databank with
	 */
	/*
	 * @ requires (* That fil is a valid filter.); ensures (* That a valid
	 * filter is applied to the databank.);
	 * 
	 * @
	 */
	public ArrayList<Question> filter(Filter fil) {
		ArrayList<Question> filtered = new ArrayList<Question>();
		for (int i = filteredQs.size() - 1; i >= 0; i--) {
			QuestionEntry qe = filteredQs.get(i);
			if (checkFiltered(fil, qe.question))
				qe.addFilter(fil);
		}
		for (int i = questions.size() - 1; i >= 0; i--) {
			QuestionEntry qe = questions.get(i);
			if (checkFiltered(fil, qe.question)) {
				qe.addFilter(fil);
			}
			else {
				questions.remove(qe);
				filteredQs.add(qe);
			}
		}
		filters.add(fil);
		newestF = fil;
		System.out.println("In QuestionDatabank.filter");
		for (QuestionEntry qe : questions)
			filtered.add(qe.question);
		return filtered;
	}

	/**
	 * unfilter removes a Filter fil from the databank. This will show any any
	 * questions that were being filtered by fil, and don't have any other
	 * filters on them.
	 * 
	 * @param fil
	 *            - filter to remove from databank search
	 */
	/*
	 * @ requires (* That one or more Filters is currently in place, and that
	 * Filter fil is a valid Filter in the databank.); ensures (* That a valid
	 * Filter is actually removed from the databank.);
	 * 
	 * @
	 */
	public void unfilter(Filter fil) {
		filters.remove(fil);
		for (int i = questions.size() - 1; i >= 0; i--) {
			QuestionEntry qe = questions.get(i);
			if (qe.filters.contains(fil))
				qe.removeFilter(fil);
		}
		for (int i = filteredQs.size() - 1; i >= 0; i--) {
			QuestionEntry qe = filteredQs.get(i);
			if (qe.filters.contains(fil))
				qe.removeFilter(fil);
			if (qe.filters.size() == filters.size()) {
				filteredQs.remove(qe);
				questions.add(qe);
			}
		}
		System.out.println("in QuestionDatabank.unfilter");
	}
	
	private boolean checkFiltered(Filter f, Question q) {
		switch (f.category.title) {
		case "Course" :
			if (f.keyword.equals(q.course)) 
				return true;
			break;
		case "Topic" :
			for (String s : q.topics) {
				if (f.keyword.equals(s))
					return true;
			}
			break;
		case "Type" :
			if (f.keyword.equals(q.type)) 
				return true;
			break;
		case "Difficulty" :
			if (f.keyword.equals(Integer.toString(q.difficulty))) 
				return true;
			break;
		case "Time" :
			if (f.keyword.equals(Integer.toString(q.time)))
				return true;
			break;
		case "Last Used" :
			if (f.keyword.equals(q.lastUsed))
				return true;
			break;
		case "Author" :
			if (f.keyword.equals(q.author))
				return true;
			break;			
		default :
			System.out.println("Shouldn't get here");
		}
		return false;
	}
	
	public ArrayList<Question> getAllByType(Filter fil) {
		ArrayList<Question> qs = new ArrayList<Question>();
		
		for (QuestionEntry qe : questions) {
			if (checkFiltered(fil, qe.question)) {
				qs.add(qe.question);
			}
		}
		for (QuestionEntry qe : filteredQs) {
			if (checkFiltered(fil, qe.question)) {
				qs.add(qe.question);
			}
		}
		
		return qs;
	}
	
	public void shiftQuestions(int[] indices, int dir) {
		QuestionEntry temp;
		System.out.println("Length " + indices.length);
		
		if (dir == 0) {
			for (int i = 0; i < indices.length; i++) {
				temp = questions.get(indices[i]);
				if (!testQs.contains(temp))
					testQs.add(temp);
				System.out.println(" Index " + indices[i]);
			}
		}
		
		else {
			int idx = questions.size();
			for (int i = indices.length - 1; i >= 0; i--) {
				temp = testQs.remove(indices[i]);
				System.out.println(" Index " + indices[i]);
			}
		}
	}
	/**
	 * question popup will bring up the question popup dialogue when a 
	 * QuestionEntry q moused over for a long enough amount of time. This will 
	 * show more detailed information of the question, such as the full 
	 * question text and answers, along with previews of any images.
	 * @param q - question to show more detail of
	 */
	/*@
		requires
			(*
			 * That q is a QuestionEntry that is in the databank, and that q is
			 * a valid QuestionEntry.
			 *);
		ensures
			(*
			 * That a valid QuestionEntry with a question from the databank is
			 * displayed.
			 *);
	@*/
	public void questionPopup(QuestionEntry q) {
		System.out.println("In QuestionDatabank.questionPopup");
	}

	public void loadDatabase(ArrayList<Question> tqs) throws FileNotFoundException {
		File inFile = new File("QuestionDB.txt");
		Scanner scanner = new Scanner(inFile);
		System.out.println("loading database");
		while (scanner.hasNextLine()) {
			Question q = parseString(scanner.nextLine());
			if (tqs.contains(q)) {
				testQs.add(new QuestionEntry(q, new ArrayList<Filter>()));
			}
			else {
				questions.add(new QuestionEntry(q, new ArrayList<Filter>()));
			}
		}
		scanner.close();
		System.out.println("database loaded");
	}
	
	public void writeDatabase() throws FileNotFoundException {
		//URL out_url = ClassLoader.getSystemResource("QuestionDB.txt");
		//File outFile = new File(out_url.toURI());
		File outFile = new File("QuestionDB.txt");
		PrintWriter writer = new PrintWriter(outFile);
		for (QuestionEntry qe : questions) {
			writer.write(qe.question.toString() + "\n");
		}
		for (QuestionEntry qe : filteredQs) {
			writer.write(qe.question.toString() + "\n");
		}
		writer.close();
		System.out.println("writing database");
	}
	
	public Question parseString(String s) {
		System.out.println("In Parse String");
		
		Question q;
		String qText, author, course,  type;
		int time, diff, points;
		ArrayList<String> topics;
		Scanner scan = new Scanner(s);
		
		qText = scan.findInLine("(?<=questionText=)(.*)(?=, author=)");		
		author = scan.findInLine("(?<=author=)(.*)(?=, lastUsed=)");
		course = scan.findInLine("(?<=course=)(.*)(?=, topics=)");
		topics = stringToArrayList(scan.findInLine("(?<=topics=)(.*)(?=, time=)"));
		time = Integer.parseInt(scan.findInLine("(?<=time=)(.*)(?=, difficulty=)"));
		diff = Integer.parseInt(scan.findInLine("(?<=difficulty=)(.*)(?=, type=)"));
		type = scan.findInLine("(?<=type=)(.*)(?=, points)");
		points = Integer.parseInt(scan.findInLine("(?<=points=)(.*)(?=,)"));
		System.out.println(type);
		try {
			switch (type) {
			case "MC" :
				ArrayList<String> pa = stringToArrayList(scan.findInLine("(?<=possibleAnswers=)(.*)(?=, correctAnswerIndices=)"));
				ArrayList<String> cai_strings = stringToArrayList(scan.findInLine("(?<=correctAnswerIndices=)(.*)"));
				ArrayList<Integer> cai = new ArrayList<Integer>();
				for (String cai_s : cai_strings)
					cai.add(Integer.valueOf(cai_s));
				q = new MCQuestion(qText, author, course, topics, time, diff, pa, cai, points);
				break;
			case "TF" :
				boolean ca = Boolean.parseBoolean(scan.findInLine("(?<=correctAnswer=)(.*)"));
				q = new TFQuestion(qText, author, course, topics, time, diff, ca, points);
				break;
			case "SA" :
				ArrayList<String> sa_kws = stringToArrayList(scan.findInLine("(?<=correctKWs=)(.*)"));
				q = new SAQuestion(qText, author, course, topics, time, diff, sa_kws, points);
				break;
			case "Essay" :
				ArrayList<String> essay_kws = stringToArrayList(scan.findInLine("(?<=correctKWs=)(.*)"));
				q = new EssayQuestion(qText, author, course, topics, time, diff, essay_kws, points);
				break;
			case "Code" :
				String path = scan.findInLine("(?<=scriptPath=)(.*)");
				q = new CodeQuestion(qText, author, course, topics, time, diff, path, points);
				break;
			default:
				q = new GraphicsQuestion(qText, author, course, topics, time, diff, points);
			}
		}
		catch (EmptyBoxException e) {
			e.printStackTrace();
			scan.close();
			return null;
		}
		
		scan.close();
		return q;
	}
	
	private ArrayList<String> stringToArrayList(String list) {
		list = list.substring(1, list.length() - 1);
		return new ArrayList<String>(Arrays.asList(list.split(", ")));
	}
}
