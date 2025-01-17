[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.

### Current Progress

:x: Adventurer subclass implementation

:x: Game screen and move progression

:x: Addons to adventurer class

## Theme

Our game will be based on the mobile video game Clash of Clans. We will be using the basic characters in the game which are the Barbarian, Wizard, and Archer. They have the ability to evolve and gain extra buffs and abilities. The boss will be the PEKKA, which can also evolve. We will be implementing two different resources from the game, elixir and dark elixir which will be used for the adventurer's attacks, supports, and evolutions.

## Adventurer Subclasses

### General Stats

| Subclass  | Description |  HP  | Damage Range | Average Elixir Cost |
| :-------: | :---------: | :--: | :----------: | :-----------------: |
| Barbarian | A skilled warrior who specializes in melee attacks with the sword. | 30 | 4-15 dmg | 2.5 elixir, 5 dark elixir |
| Wizard | A master of fire magic who uses spells to attack enemies. | 20 | 4-9 dmg; Chance of burn | 2.5 elixir, 6 dark elixir |
| Archer | A master of the bow and arrow. It is said she has never missed a shot. | 24 | 3-9 dmg; Chance of bleed | 2.5 elixir, 5.5 dark elixir |
| PEKKA | A machine made for combat, dealing high damage with its saber. | 40 | 10-15 dmg | 2.5 elixir, 5 dark elixir |

### Barbarian Abilities

| Abilities | Description | Damage | Elixir Used |
| :-------: | :---------: | :----: | :---------: |
| Attack | Sword Swing: The barbarian skillfully swings its sword at the opponent, dealing damage. | 4 dmg | 2 elixir |
| Special | Consecutive Swings: The barbarian launches a series of two attacks on multiple random targets. If it hits the same target consecutively, extra damage is dealt. | 4 dmg (x2); 150% dmg each hit if consecutive | 4 dark elixir |
| Ally Support | Heal: A heal spell is cast on the targeted ally. | N/A | 3 elixir |
| Self Support | Evolution: The barbarian rages itself up, gaining a stat boost and becoming more resourceful with its elixir. | 150% dmg from rage (stacks with special), 25% chance to deal an additional 50% more. | 6 dark elixir |

### Wizard Abilities

| Abilities | Description | Damage | Elixir Used |
| :-------: | :---------: | :----: | :---------: |
| Attack | Fireball: The wizard sends a flaming fireball at the target, dealing high fire damage. | 6 dmg | 2 elixir |
| Special | Flamethrower: The wizard shoots flames from its hands, damaging all opponents and leaving them with a chance of burn. | 4 dmg to each enemy; 10% chance to burn, dealing 2 dmg at the end of each turn. | 6 dark elixir |
| Ally Support | Heal: A heal spell is cast on the targeted ally. | N/A | 3 elixir |
| Self Support | Evolution: The wizard cloaks itself in a fire shield, which explodes on all enemies upon destruction. | Fire shield with 10 HP that when broken, does 3 dmg to all. | 6 dark elixir |

### Archer Abilities

| Abilities | Description | Damage | Elixir Used |
| :-------: | :---------: | :----: | :---------: |
| Attack | Tracking Shot: The archer shoots an arrow at the selected target which never misses. | 3 dmg | 2 elixir |
| Special | Long Distance Shot: The archer fires an arrow randomly at the opponents. If the opponent is not directly in front of the archer, the arrow deals more damage and has a chance to inflict the bleeding effect. | 3 dmg if opponent is in front of the archer. 200% dmg if not in front. 50% chance to bleed, dealing 2 dmg at the end of each turn. | 5 dark elixir |
| Ally Support | Heal: A heal spell is cast on the targeted ally. | N/A | 3 elixir |
| Self Support | Evolution: The archer uses ragged tips for its arrows and increases its dark energy supply. | 30% chance for every arrow to inflict bleed, 2 dark elixir gained after every turn. | 6 dark elixir |

### PEKKA Abilities

| Abilities | Description | Damage | Elixir Used |
| :-------: | :---------: | :----: | :---------: |
| Attack | Saber Swing: The PEKKA swings its saber at the enemy, dealing high damage. However, this can only be used every other turn. | 12 dmg | 2 elixir |
| Special | Limb Breaker: The PEKKA swings at the opponents limbs, shattering them. | 10 dmg, Attacking them the next turn deals 150% damage | 4 dark elixir |
| Ally Support | Heal: A heal spell is cast on the targeted ally. | N/A | 3 elixir |
| Self Support | Evolution: The PEKKA evolves, gaining a stat boost. Also, after every attack, the PEKKA heals two HP. | 125% dmg, +2 HP after every attack. | 6 dark elixir |
