import os
import re

# Configurações
base_class_name = "Endereco"
target_names = ["Lotacao"]
source_dir = "./endereco"
output_base_dir = "."

def is_entity_class(content):
    return (
        f"class {base_class_name}" in content and
        "@Entity" in content
    )

def create_modified_files(target_name):
    for root, _, files in os.walk(source_dir):
        for file in files:
            if not file.endswith(".java"):
                continue

            filepath = os.path.join(root, file)
            with open(filepath, "r", encoding="utf-8") as f:
                content = f.read()

            if is_entity_class(content):
                continue

            content = content.replace(base_class_name, target_name)
            content = content.replace(base_class_name.lower(), target_name.lower())
            content = re.sub(
                r'@RequestMapping\(".*?"\)',
                f'@RequestMapping("/{target_name.lower()}")',
                content
            )
            content = re.sub(
                r'package (.*\.){};'.format(base_class_name.lower()),
                r'package \1{};'.format(target_name.lower()),
                content
            )
            content = re.sub(
                rf'public (class|interface) (\w*{target_name}\w*)',
                lambda m: f'public {m.group(1)} {m.group(2).replace(base_class_name, target_name)}',
                content
            )

            relative_path = os.path.relpath(filepath, source_dir)
            new_relative_path = relative_path.replace(base_class_name, target_name).replace(base_class_name.lower(), target_name.lower())
            output_path = os.path.join(output_base_dir, target_name.lower(), new_relative_path)

            os.makedirs(os.path.dirname(output_path), exist_ok=True)

            with open(output_path, "w", encoding="utf-8") as f:
                f.write(content)

for name in target_names:
    create_modified_files(name)

print("✅ Cópia e modificação concluídas.")
