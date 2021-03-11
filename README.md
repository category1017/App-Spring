### 안드로이드앱의 라이프사이클
로그인액티비티기준 상태6가지
onCreate 생성
onDestroy 소멸
onStart 시작
onStop 정지
onResume 재실행
onPause 일시정지

로그인했을때, onPause(일시정지)→ onStop(정지)
뒤로가기 했을때, onStart(시작)→onResume(재실행)
로그아웃했을때, onCreate(생성) → onStart(시작)→ onResume(재실생)