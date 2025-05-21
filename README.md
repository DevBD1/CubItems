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

📥 Installation
	1.	Place CubItems.jar in /plugins
	2.	Make sure Corlex is installed
	3.	Install ProtocolLib
	4.	Restart server

🧪 Commands
Command
Description
/giveitem <key>
Gives a registered item

🧩 Requirements
	•	Paper 1.20+ or 1.21+
	•	ProtocolLib
	•	Corlex (optional but recommended)

⸻

🛠 Developers

Use the cubItems NBT key to identify and extend custom items across your plugin ecosystem.

⸻

📄 License
MIT — do what you want, give credit if you like it.


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


