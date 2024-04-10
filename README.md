AzureAD/microsoft-authentication-library-for-java#806

# msal4j v1.15.0 backward-compatibility problem

## How to reproduce

1) Build an app with:

```shell
./gradlew :app:installDist
```

2) Ensure the app is running as expected:

```shell
./app/build/install/app/bin/app
```

3) Make `AbstractBuilder` to extend `BuilderBase` and
comment out `AbstractBuilder#{executorService/self}` methods

```java
abstract class AbstractBuilder<T extends AbstractBuilder<T>> extends BuilderBase<T> {
//    public T executorService() {
//        return self();
//    }
//
//    abstract T self();
}
```

4) Build an updated `lib.jar` with:

```shell
./gradlew :lib:jar
```

5) copy it to `lib` directory of app's distribution:

```shell
cp -f ./lib/build/libs/lib.jar ./app/build/install/app/lib/lib.jar
```

6) Run the app again to see the `java.lang.NoSuchMethodError`

```shell
./app/build/install/app/bin/app
```

```text
Exception in thread "main" java.lang.NoSuchMethodError: 'org.example.lib.AbstractBuilder org.example.lib.Builder.executorService()'
        at org.example.app.App.main(App.java:8)
```
