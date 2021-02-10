# ModelAPI
A Nukkit plugin that provides simple EntityHuman spawning with custom skin

### Usage
Example with coin model from https://github.com/iteplenky/CoinModel
```java
String name = "coin-model";
Path path = getDataFolder().toPath();
Path skinPath = path.resolve("model-texture.png");
Path geometryPath = path.resolve("model-geometry.json");
Skin skin = ModelAPI.createSkin(name, skinPath, geometryPath);
Model model = ModelAPI.createModel(position, skin);
```
