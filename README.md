# Android Note

### 설명
안드로이드를 공부하면서 배운 기능들을 정리한 레포지토리

### 목록

<!-- STT (SpeechToText) -->
<details>
<summary>STT (SpeechToText)</summary>
<div markdown="1">
<br>

~~~
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.RECORD_AUDIO" />

<queries>
        <intent>
            <action android:name="android.speech.RecognitionService" />
        </intent>
</queries>
~~~
  
[참고 URL] (https://itstory1592.tistory.com/50)

</div>
</details>

<!-- Coroutines -->
<details>
<summary>Coroutines </summary>
<div markdown="1">
<br>

~~~
dependencies {
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9'
}
~~~
  
[참고 URL] (https://github.com/seyoungcho2/CoroutinesKoreanTranslation/tree/main)
<br>
[참고 URL] (https://developer.android.com/kotlin/coroutines?hl=ko#groovy)

</div>
</details>

<!-- ImmortalService(Foreground) -->
<details>
<summary>ImmortalService(Foreground) </summary>
<div markdown="1">
<br>

~~~
        <uses-permission android:name="android.permission.FOREGROUND_SERVICE"/>

        <application>
                ...
                <service android:name=".ImmortalService"></service>
                ...
        </application>
~~~
  
[참고 URL] (https://github.com/jwl-97/immortalService/tree/main)

</div>
</details>
