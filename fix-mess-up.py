import os
import json

# Path to your blockstates folder
blockstates_path = r"C:\Documents\Sewers N Systems\src\main\resources\assets\sewers_n_systems\blockstates"

# Replacement
old_text = "minecraft:"
new_text = "sewers_n_systems:"

for root, _, files in os.walk(blockstates_path):
    for file in files:
        if file.endswith(".json"):
            file_path = os.path.join(root, file)
            with open(file_path, "r", encoding="utf-8") as f:
                content = f.read()
            # Replace only in the content of the JSON
            content = content.replace(old_text, new_text)
            with open(file_path, "w", encoding="utf-8") as f:
                f.write(content)
            print(f"Fixed {file_path}")
