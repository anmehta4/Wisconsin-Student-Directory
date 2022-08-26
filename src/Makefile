run: compile
	@echo "Running the application StudentDirectory"
	java StudentDirectory

compile: CSVTOHTML.class StudentDirectory.class HashTableMap.class KeyValue.class MapADT.class WiscID.class WiscIDList.class TestClass.class
	@echo "Successfully compiled all project files"

build:
	javac -source 1.7 -target 1.7 -cp . CSVTOHTML.java

htmlrun: build
	java -cp . CSVTOHTML

upload: build
	./upload

CSVTOHTML.class: CSVTOHTML.java
	javac CSVTOHTML.java

StudentDirectory.class: StudentDirectory.java
	javac StudentDirectory.java

HashTableMap.class: HashTableMap.java
	javac -cp .:opencsv-5.3.jar HashTableMap.java

KeyValue.class: KeyValue.java
	javac KeyValue.java

MapADT.class: MapADT.java
	javac MapADT.java

WiscID.class: WiscID.java
	javac WiscID.java

WiscIDList.class: WiscIDList.java WiscID.class
	javac WiscIDList.java

TestClass.class: junit5.jar TestClass.java
	javac -cp .:junit5.jar TestClass.java

test: compile junit5.jar
	@echo "Testing the application WisconsinDirectory"
	java -jar junit5.jar --class-path . --scan-classpath --details tree

junit5.jar: junit5.jar
	wget http://pages.cs.wisc.edu/~cs400/junit5.jar

clean:
	$(RM) *.class
