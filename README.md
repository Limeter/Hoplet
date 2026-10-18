<p align="center">
  <img src="icon.png" width="128" height="128" alt="Hoplet logo">
</p>

<h1 align="center">Hoplet</h1>

<p align="center">Removes the vanilla 4-tick jump cooldown — hold Space and hop continuously.</p>

- Client-side only: works on vanilla and modded servers, nothing to install server-side
- No settings, no keybinds, no dependencies beyond the loader (Fabric API on Fabric)
- One event handler, ~20 lines of code

## Download

[Modrinth](https://modrinth.com/mod/hoplet) · [Releases](https://github.com/Limeter/Hoplet/releases)

| Minecraft | Forge | Fabric |
|---|---|---|
| 1.20.1 | [jar](https://github.com/Limeter/Hoplet/releases/download/v1.0.0/hoplet-1.0.0-forge-1.20.1.jar) | [jar](https://github.com/Limeter/Hoplet/releases/download/v1.0.0/hoplet-1.0.0-fabric-1.20.1.jar) |
| 1.21.4 | [jar](https://github.com/Limeter/Hoplet/releases/download/v1.0.0/hoplet-1.0.0-forge-1.21.4.jar) | [jar](https://github.com/Limeter/Hoplet/releases/download/v1.0.0/hoplet-1.0.0-fabric-1.21.4.jar) |
| 1.21.11 | [jar](https://github.com/Limeter/Hoplet/releases/download/v1.0.0/hoplet-1.0.0-forge-1.21.11.jar) | [jar](https://github.com/Limeter/Hoplet/releases/download/v1.0.0/hoplet-1.0.0-fabric-1.21.11.jar) |

Fabric builds require [Fabric API](https://modrinth.com/mod/fabric-api).

## Repository layout

Every target lives in its own branch with the project at the repository root:

| Branch | Minecraft | Loader | Toolchain |
|---|---|---|---|
| [`forge-1.20.1`](https://github.com/Limeter/Hoplet/tree/forge-1.20.1) | 1.20.1 | Forge 47.x | Java 17, ForgeGradle 6 |
| [`fabric-1.20.1`](https://github.com/Limeter/Hoplet/tree/fabric-1.20.1) | 1.20.1 | Fabric API 0.92.x | Java 17, Loom 1.8 |
| [`forge-1.21.4`](https://github.com/Limeter/Hoplet/tree/forge-1.21.4) | 1.21.4 | Forge 54.x | Java 21, ForgeGradle 7 |
| [`fabric-1.21.4`](https://github.com/Limeter/Hoplet/tree/fabric-1.21.4) | 1.21.4 | Fabric API 0.119.x | Java 21, Loom 1.12 |
| [`forge-1.21.11`](https://github.com/Limeter/Hoplet/tree/forge-1.21.11) | 1.21.11 | Forge 61.x | Java 21, ForgeGradle 7 |
| [`fabric-1.21.11`](https://github.com/Limeter/Hoplet/tree/fabric-1.21.11) | 1.21.11 | Fabric API 0.141.x | Java 21, Loom 1.19 |

## Building

```powershell
git clone -b forge-1.20.1 https://github.com/Limeter/Hoplet.git
cd Hoplet
.\gradlew.bat build
```

The jar is written to `build/libs/hoplet-1.0.0.jar`.

## How it works

The vanilla player jump is gated by a 4-tick cooldown. Each client tick the mod
resets it to zero, so holding Space hops continuously:

- **Forge** — `ClientTickEvent` (end of tick) sets `LivingEntity.noJumpDelay = 0`,
  made accessible through an access transformer
- **Fabric** — `ClientTickEvents.END_CLIENT_TICK` sets `LivingEntity.jumpingCooldown = 0`
  through an accessor mixin

## License

[MIT](LICENSE)