* to execute and run test cases

  mvn clean install exec:java -Dexec.mainClass="mainapp.MyApp" -DskipTests=true

git config --global user.email ""
git config --global user.name ""
-----------------------------------------------------------------------------------
git init
echo "first line in first file" > file.txt
echo "first line in second file" > file2.txt
git add file.txt
git commit -m "adding file.txt"
git add file2.txt
git commit --amend
git revert <first line in first file>