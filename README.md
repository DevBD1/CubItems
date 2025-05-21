# CubItems

✨ Custom item framework for Minecraft servers.  
🧱 Define items via YAML.  
🌐 Supports [Corlex](https://github.com/DevBD1/CubItems) for localized client-side lore.  
🔗 Works seamlessly with ProtocolLib.

---

## ✨ Features

- 📦 YAML-defined custom items
- 🏷️ Automatic NBT tagging for identification
- 🧙 Dynamic lore powered by [Corlex](https://github.com/DevBD1/CubItems)
- 🌍 Multilingual support with fallback
- 🚀 Fully client-side fake lore with ProtocolLib
- 💡 Easy item distribution with `/giveitem <key>`

---

## 📥 Installation

- Stop the server
- Place ```CubItems.jar``` in ```/plugins```
- Install [ProtocolLib](https://ci.dmulloy2.net/job/ProtocolLib/)
- Install [Corlex](https://github.com/DevBD1/CubItems) if you want client-side lore implementation
- Start the server

---

Commands | Description | Permission | Group
--- | --- | --- | --- 
/giveitem <key> | Gives a registered item | cubitems.giveitem | cubitems.admin

---

## 🧩 Requirements
- Spigot or Paper 1.21+
- ProtocolLib
- Corlex (optional but recommended)

---

## 🛠 Developers

Use the cubItems NBT key to identify and extend custom items across your plugin ecosystem.

---

## 📄 License
MIT — do what you want, give credit.

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


