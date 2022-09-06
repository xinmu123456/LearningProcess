all: main

main: main.o calculator.o A.o B.o
	g++ main.o calculator.o A.o B.o -o main

main.o: main.cpp
	g++ -c main.cpp

calculator.o: calculator.h calculator.cpp
	g++ -c calculator.cpp

A.o: A.cpp A.h
	g++ -c A.cpp 

B.o: B.cpp B.h
	g++ -c B.cpp

clean:
	rm *.o main