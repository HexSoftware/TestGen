# simple script to quickly remove all data in files
# and then change the name to include "TEST" at the end
for file in *.java
do
	cat /dev/null > $file
	mv -- "$file" "${file%.java}TEST.java"
done
