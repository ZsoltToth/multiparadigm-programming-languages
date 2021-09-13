cmake_minimum_required(VERSION 3.20)
project(fileHandling C)

set(CMAKE_C_STANDARD 99)

add_executable(fileHandling main.c file_handling.h file_handling.c)
