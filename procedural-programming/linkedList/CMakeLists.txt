cmake_minimum_required(VERSION 3.19)
project(linkedList C)

set(CMAKE_C_STANDARD 99)

add_executable(linkedList main.c linked_list.h linked_list.c)
