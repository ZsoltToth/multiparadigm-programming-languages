# Java Project Template

Technologies:
 - Java 11+
 - Maven 3.6+

CI:
 - Github Action
 - Checkstyle check
 - JaCoCo Line Coverage min. 80%

## SOLID

 - Single Responsibility 
 - Open - Close
 - Liskov Substitution
 - Interface Segregation
 - Dependency Inversion


## Dependency Injection
 - Constructor
 - Setter Method
 - Field (no, no)

## Has_A Connection
 - Association
 - Aggregation
 - Composition

# Testing

## Levels

1) __Unit & Component__
2) __Integration__
3) System
4) End-To-End
5) Others: Penetration, Load, etc.
6) Acceptance


## FIRST 
- Fast
- Isolated
- Repeatable
- Self Validating
- Timely / Thorough

## Given When Then
```java
void test(){
    // given
    state initialization steps
    mocking
    etc.
    // when
    call tested service
    // then
    assertions
    checking
    }
```