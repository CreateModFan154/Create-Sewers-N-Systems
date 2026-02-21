import json
from pathlib import Path

MODID = "sewersnsystems"

# OUTPUT ROOT
ROOT = Path("generated")
CONFIGURED = ROOT / "data" / MODID / "worldgen" / "configured_feature"
PLACED = ROOT / "data" / MODID / "worldgen" / "placed_feature"

CONFIGURED.mkdir(parents=True, exist_ok=True)
PLACED.mkdir(parents=True, exist_ok=True)

def generate_ore(
    name,
    block_id,
    size,
    veins_per_chunk,
    min_y,
    max_y,
    discard_chance=0.0
):
    # CONFIGURED FEATURE
    configured = {
        "type": "minecraft:ore",
        "config": {
            "size": size,
            "discard_chance_on_air_exposure": discard_chance,
            "targets": [
                {
                    "target": {
                        "predicate_type": "minecraft:tag_match",
                        "tag": "minecraft:stone_ore_replaceables"
                    },
                    "state": {
                        "Name": block_id
                    }
                }
            ]
        }
    }

    # PLACED FEATURE
    placed = {
        "feature": f"{MODID}:{name}",
        "placement": [
            {
                "type": "minecraft:count",
                "count": veins_per_chunk
            },
            {
                "type": "minecraft:in_square"
            },
            {
                "type": "minecraft:height_range",
                "height": {
                    "type": "minecraft:uniform",
                    "min_inclusive": {
                        "absolute": min_y
                    },
                    "max_inclusive": {
                        "absolute": max_y
                    }
                }
            },
            {
                "type": "minecraft:biome"
            }
        ]
    }

    with open(CONFIGURED / f"{name}.json", "w") as f:
        json.dump(configured, f, indent=2)

    with open(PLACED / f"{name}.json", "w") as f:
        json.dump(placed, f, indent=2)

    print(f"Generated ore: {name}")

# -----------------------
# ADD ORES HERE
# -----------------------

generate_ore(
    name="phosphate_ore",
    block_id=f"{MODID}:phosphate_ore",
    size=9,
    veins_per_chunk=20,
    min_y=0,
    max_y=72,
    discard_chance=0.0
)
generate_ore(
    name="deepslate_phosphate_ore",
    block_id=f"{MODID}:deepslate_phosphate_ore",
    size=9,
    veins_per_chunk=20,
    min_y=-32,
    max_y=0,
    discard_chance=0.0
)
