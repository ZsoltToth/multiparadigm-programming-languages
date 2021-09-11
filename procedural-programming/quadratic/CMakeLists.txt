cmake_minimum_required(VERSION 3.17)
project(procedural_programming C)

set(CMAKE_C_STANDARD 99)


add_executable(procedural_programming main.c quadratic.h quadratic.c)

target_link_libraries(procedural_programming m)