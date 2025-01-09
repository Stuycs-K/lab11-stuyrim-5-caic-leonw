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

Our game will be based on the mobile video game Clash of Clans. We will be using the basic characters in the game which are the Barbarian, Wizard, and Archer. As enemies, they have the chance of turning into bosses, where they become evolved versions of themselves with buffed stats and special abilities. We will be implementing two different resources from the game, elixir and dark elixir which will be used for the adventurer's attacks and supports.

## Adventurer Subclasses

### General Stats

| Subclass  | Description |  HP  | Damage Range | Average Elixir Cost | Evolved Buffs |
| :-------: | :---------: | :--: | :----------: | :-----------------: | :-----------: |
| Barbarian | A skilled warrior who specializes in melee attacks with the sword. | 30 | 4-15 dmg | 3 elixir, 4 dark elixir | 1.33x HP, always raged, 25% chance to recover 50% of elixir spent after turn. |
| Wizard    | A master of fire magic who uses spells to attack enemies. | 20 | 4-9 dmg; Chance of burn | 3 elixir, 6 dark elixir | 1.5x HP, fire shield with 10 HP that when broken, does 3 dmg to all. |
| Archer    | A master of the bow and arrow. It is said she has never missed a shot. | 24 | 3-9 dmg; Chance of bleed | 3 elixir, 5 dark elixir | 1.25x HP, 30% chance for every arrow to inflict bleed, 2 dark elixir gained after every turn. |

### Barbarian Abilities

| Abilities | Description | Damage | Elixir Used |
| :-------: | :---------: | :----: | :---------: |
| Attack | Sword Swing: The barbarian skillfully swings its sword at the opponent, dealing damage. | 4 dmg               | 2 elixir    |
| Special | Consecutive Swings: The barbarian launches a series of two attacks on multiple random targets. If it hits the same target consecutively, extra damage is dealt. | 4 dmg (x2); 1.25x dmg each hit if consecutive | 4 dark elixir |
| Ally Support | Heal: A heal spell is cast on the targeted ally. | N/A | 3 elixir |
| Self Support | Rage: A rage spell is applied to itself, increasing its damage dealt. | 1.5x dmg | 4 elixir |

### Wizard Abilities

| Abilities | Description | Damage | Elixir Used |
| :-------: | :---------: | :----: | :---------: |
| Attack | Fireball: The wizard sends a flaming fireball at the target, dealing high fire damage. | 6 dmg | 2 elixir |
| Special | Flamethrower: The wizard shoots flames from its hands, damaging all opponents and leaving them with a chance of burn. | 4 dmg to each enemy; 10% chance to burn, dealing 2 dmg at the end of each turn. | 6 dark elixir |
| Ally Support | Heal: A heal spell is cast on the targeted ally. | N/A | 3 elixir |
| Self Support | Rage: A rage spell is applied to itself, increasing its damage dealt. | 1.5x dmg | 4 elixir |

### Archer Abilities

| Abilities | Description | Damage | Elixir Used |
| :-------: | :---------: | :----: | :---------: |
| Attack | Tracking Shot: The archer shoots an arrow at the selected target which never misses. | 3 dmg | 2 elixir |
| Special | Long Distance Shot: The archer fires an arrow randomly at the opponents. If the opponent is not directly in front of the archer, the arrow deals more damage and has a chance to inflict the bleeding effect. | 3 dmg if opponent is in front of the archer. 2x dmg if not in front. 50% chance to bleed, dealing 2 dmg at the end of each turn. | 5 dark elixir |
| Ally Support | Heal: A heal spell is cast on the targeted ally. | N/A | 3 elixir |
| Self Support | Rage: A rage spell is applied to itself, increasing its damage dealt. | 1.5x dmg | 4 elixir |
