# Nombre del ejecutable
TARGET = output/programa

# Los archivos .cpp en la carpeta src
SRCS = $(wildcard src/*.cpp)

# Archivos objeto (.o) generados a partir de los archivos .cpp
OBJS = $(SRCS:.cpp=.o)

# Las opciones de compilación, agregando -g para depuración
CFLAGS = -g -Wall

# El objetivo por defecto
all: $(TARGET)

# Cómo crear el ejecutable
$(TARGET): $(OBJS)
	 g++ $(CFLAGS) -o $(TARGET) $(OBJS)

# Cómo compilar los archivos .cpp a .o
%.o: %.cpp
	 g++ $(CFLAGS) -c $< -o $@

# Limpiar archivos generados
clean:
	 rm -f src/*.o $(TARGET)
