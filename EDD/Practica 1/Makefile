# Definir el compilador y las banderas
CC = g++
CFLAGS = -Wall -Wextra -g3

# Archivos fuente y objetos
SRC = main.cpp miClase.cpp
OBJ = $(SRC:.cpp=.o)

# Ruta del ejecutable
OUT = output/main

# Regla para generar el ejecutable
$(OUT): $(OBJ)
	$(CC) $(OBJ) -o $(OUT)

# Regla para compilar los archivos .cpp en archivos .o
%.o: %.cpp
	$(CC) $(CFLAGS) -c $<

# Limpiar los archivos objeto y ejecutable
clean:
	rm -f $(OBJ) $(OUT)
