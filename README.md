# README

Example Repo for question: https://stackoverflow.com/questions/75111282/using-spring-boot-mockbean-annotation-in-test-inheritance?noredirect=1#comment132548073_75111282

## Running the tests
See stdout for the test output.
```bash
./gradlew test
```
It should contain:
```
FirstTest
BeanToConsume is of type: com.example.mockbeantest.BeanToConsume
SecondTest
BeanToConsume is of type: com.example.mockbeantest.BeanToConsume
```

Although I would expect the SecondTest to print a Mock of BeanToConsume.
