springboot-bower-gulp-angular
==============================

> 배울 것이 많다.... 특히 프론트엔드쪽은...

## 요구사항
* JDK 8 권장
* `npm`, `bower`, `gulp` 가 설치되어 있어야 한다.
	- `bower` 설치
	```
	$ (sudo) npm install -g bower
	$ (sudo) npm install -g gulp
	```

* `.bowerrc` 를 통해서 bower 컴포넌트 설치 위치 지정
* `bower` 를 이용해서 의존성 컴포넌트들 설치
* `sass` 지정

* `gulp` 프로젝트 의존성 설치방법
```
$ npm install gulp --save-dev // 기타등등...
```

> `--save-dev` 플러그인을 추가하면 의존성들을 `devDependency` 로 설치하게되는데, 이 옵션을 주는 이유는 Gulp 와 관련 의존성들은 앱 개발 과정까지만 필요하기 때문이다. Gulp 의 플러그인들을 설치할 때도 같은 `--save-dev` 옵션을 주어야 한다.


## 프로젝트 시작
1. 프로젝트 복제
2. bower 를 이용한 프론트엔드 의존성 추가