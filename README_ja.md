# Processing4 Gradle Template

Processing4.x を Gradle9 と Java17 で開発するための、クロスプラットフォームなテンプレートプロジェクトです。intelliJ IDEA や Eclipse, VS Code などの IDE で Processing スケッチを Java プロジェクトとして開発できます。

## クイックスタート

1. このリポジトリをクローンまたはダウンロードします。
2. コマンドラインでプロジェクトディレクトリに移動します。
3. 以下のコマンドを実行して、Processing スケッチをビルドおよび実行します。

### For Windows

```bash
gradlew.bat run
```

### For macOS/Linux

```bash
chmod +x gradlew
./gradlew run
```

### 開発の開始

`src/main/java/io/github/noah_devtech/Main.java` を編集してコードを書き始めてください。

## 技術スタック

- Processing: 4.3.3
- Gradle: 9.0.0
- Java(JDK): 17
- JOGL/GlueGen: 2.5.0
- Kotlin Standard Library:2.2.20