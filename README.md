
## pre-install

1. install OpenJDK8
    - set `JAVA_HOME` environment variable
1. (optional) install latest gradle
    - otherwise just use `$ ./gradlew`
1. (optional) install python 2.7.x
    - set `PYTHON` environment variable
    - `$ gradle npminstall` may complain otherwise

## First
* Robimy clona repo

## build & run

* `$ gradle build`
* `Run as SpringBoot App`
* using browser, navigate to`localhost:8080`

## FrontEnd watcher

* `$ gradle gulp_watch`

### Refresh FrontEnd, witchout SpringBoot restart

* `$ gradle gulp_build`

 Koniec ;) 

 



## license
[MIT](/LICENSE)
