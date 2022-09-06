all: main

main: main.o add.o
	g++ main.o add.o -o main

main.o: main.cpp
	g++ -c main.cpp

add.o: add.cpp
	g++ -c add.cpp

clean: 
	rm main main.o add.o
	
