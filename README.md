[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.

## Theme

Our game will be based on the mobile video game Clash of Clans. We will be using the basic characters in the game which are the Barbarian, Wizard, and Archer. As enemies, they have the chance of turning into bosses, where they become evolved versions of themselves with buffed stats and special abilities. We will be implementing two different resources from the game, elixir and dark elixir which will be used for the adventurer's attacks and supports.

## Adventurer Subclasses

### General Stats

| Subclass  | Description                          | HP    | Damage Range | Average Elixir Cost     | Evolved Buffs                           |
| :-------: | :----------------------------------: | :---: | :----------: | :---------------------: | :-------------------------------------: |
| Barbarian | A skilled warrior who specializes    | 30    | 4-15 dmg     | 3 elixir, 4 dark elixir | 1.33x HP, 1.25x dmg, 25% chance to      |
|           | in melee attacks with the sword.     |       |              |                         | recover 50% of elixir spent after turn  |
| Wizard    | A master of the dark arts who uses   |
|           | spells to attack enemies.            |
| Archer    | A master of the bow and arrow. It is |
|           | said she has never missed a shot.    |

### Barbarian Abilities

| Abilities     | Description                                      | Damage             | Elixir Used |
| :-----------: | :----------------------------------------------: | :----------------: | :---------: |
| Attack        | Sword Swing: The barbarian skillfully swings its | 4 dmg              | 2 elixir    |
|               | sword at the opponent, dealing damage.           |                    |             |
| Special       | Consecutive Swings: The barbarian launches a     | 4 dmg (x2)         | 4 dark      |
|               | series of two attacks on multiple random targets.| 1.25x dmg each hit | elixir      |
|               | If it hits the same target consecutively, extra  | if consecutive     |             |
|               | damage is dealt.                                 |                    |             |
| Ally Support  | Heal: A heal spell is cast on the targeted ally. | N/A                | 3 elixir    |
| Self Support  | Rage: A rage spell is applied to itself,         | 1.5x dmg           | 4 elixir    |
|               | increasing its damage dealt.                     |                    |             |

### Wizard Abilities


### Archer Abilities
