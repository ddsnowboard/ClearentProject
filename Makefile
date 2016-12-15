.PHONY: all clean test tags vim
JUNIT="http://search.maven.org/remotecontent?filepath=junit/junit/4.12/junit-4.12.jar"
HAMCREST="http://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar"
all : bin hamcrest.jar junit.jar
	zsh -c "javac -cp ./src:hamcrest.jar:junit.jar -d bin src/**/*.java"

clean :
	-rm -rf bin
	-rm *.jar 2>/dev/null
	-rm tags

test : all hamcrest.jar junit.jar bin/UnitTest.class
	java -cp .:junit.jar:hamcrest.jar:bin org.junit.runner.JUnitCore UnitTest  

hamcrest.jar :
	wget -O hamcrest.jar $(HAMCREST)

junit.jar :
	wget -O junit.jar $(JUNIT)

bin : 
	mkdir bin

tags :
	zsh -c "ctags -R ./**/*.java(N)"

vim :
	zsh -c "vim ./**/*.java"

bin/test/SwaggerTest.class : src/test/SwaggerTest.java
	javac -cp hamcrest.jar:junit.jar:./src/ src/test/SwaggerTest.java -d bin

