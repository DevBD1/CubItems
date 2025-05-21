# CubItems

✨ Custom item framework for Minecraft servers.  
🧱 Define items via YAML.  
🌐 Supports Corlex for localized client-side lore.  
🔗 Works seamlessly with ProtocolLib.

---

## ✅ Features

- 📦 YAML-defined custom items
- 🏷️ Automatic NBT tagging for identification
- 🧙 Dynamic lore powered by [Corlex](https://github.com/YourName/Corlex)
- 🌍 Multilingual support with fallback
- 🚀 Fully client-side fake lore with ProtocolLib
- 💡 Easy item distribution with `/giveitem <key>`

---

## 🔧 Example `items.yml`

```yaml
items:
  strength_sword:
    material: DIAMOND_SWORD
    display_name: "&cSword of Strength"
    lore:
      en:
        - "&7A sharp blade."
        - "&c+10 Strength"
      tr:
        - "&7Keskin bir kılıç."
        - "&c+10 Güç"
    nbt:
      customKey: strength_sword