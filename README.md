# Blub Launcher

Простой Android-проект на Kotlin и Jetpack Compose. На главном экране собраны фон, логотип, маскот и кнопки из исходных картинок.

## Как открыть и запустить

1. Откройте папку проекта в Android Studio.
2. Дождитесь, пока Android Studio закончит синхронизацию Gradle.
3. Подключите телефон с включённой отладкой по USB или запустите виртуальный телефон.
4. Нажмите **Run** (зелёный треугольник).

Кнопки «Играть», «Настройки», «Версии» и «Аккаунт» пока ничего не делают.

## Как собрать APK

В Android Studio откройте вкладку **Terminal** и выполните:

```bash
./gradlew assembleDebug
```

Готовый файл появится здесь: `app/build/outputs/apk/debug/app-debug.apk`.

GitHub Actions также собирает debug APK при каждом push и pull request. APK можно скачать на странице запуска workflow в разделе **Artifacts**.

## Где находятся файлы

- `app/src/main/java/com/blublauncher/app/MainActivity.kt` — экран приложения.
- `app/src/main/res/drawable-nodpi/` — изображения из архива `blub_assets_sliced.zip`.
- `.github/workflows/android.yml` — автоматическая сборка APK на GitHub.
