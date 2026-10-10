# Conformance of Processes and Goals

**Conformance of Processes and Goals** is a plugin for the [USE (UML-based Specification Environment)](https://useocl.sourceforge.net/). It connects process, goal, and state models so they can be visualized, checked for conformance, and used to generate executable process scenarios from one desktop tool.

## Plugin features

The plugin adds the **Conformance of Processes and Goals** menu to USE with seven tools:

| Tool | Purpose | Main input |
|---|---|---|
| **CSL View Model** | Compile and visualize a CSL state model | `.csl` |
| **Goal View Model** | Compile and visualize an iStar goal model | `.istar` |
| **Process View Model** | Compile and visualize a BPMN process | `.bpmn2` |
| **Norm View Model** | Compile and visualize a NormML norm model | `.normml` |
| **CSL State View** | Evaluate OCL invariants over a CSL state snapshot | `.csl`, `.aol` |
| **Conformance Checking** | Verify conformance of iStar goals against BPMN processes via CSL state | `.csl`, `.bpmn2`/`.bpmn`, `.istar` |
| **DCR View Model** | Compile and visualize a DCR graph | `.dcr` |

## Screenshots

![Plugin menu](docs/images/plugin-menu.png)

![Model views](docs/images/model-views.png)

## Requirements

- Git
- JDK 21
- Apache Maven 3.9 or later

Verify the Java and Maven installations:

```bash
java -version
mvn -version
```

## Installation

Clone the repository together with its USE submodule:

```bash
git clone --recurse-submodules <repository-url>
cd use4Goal
```

If the repository has already been cloned, initialize the submodule with:

```bash
git submodule update --init --recursive
```

Build the USE host and install the plugin from the repository root:

```bash
mvn clean package -Dmaven.test.skip=true
```

The deployable plugin is copied automatically to:

```text
use/use-assembly/target/use-7.1.1/lib/plugins/goal-7.1.1-complete.jar
```

### Installing into an existing USE distribution

Copy:

```text
goal/target/goal-7.1.1-complete.jar
```

to:

```text
<USE_HOME>/lib/plugins/
```

Use only `goal-7.1.1-complete.jar`. Do not install `goal-7.1.1.jar` beside it; the complete JAR contains the runtime dependencies required by the plugin's isolated classloader.

## Starting the plugin

Start the bundled USE application on Windows:

```powershell
.\use\use-assembly\target\use-7.1.1\bin\start_use.bat
```

On Linux or macOS:

```bash
./use/use-assembly/target/use-7.1.1/bin/use
```

After USE opens, select **Conformance of Processes and Goals** from the main menu.

## Usage

Ready-to-use model sets are available in [`examples/`](examples/). The [`examples/Forecast/`](examples/Forecast/) directory contains BPMN, iStar, and CSL models suitable for a first run.

### Visualize a model

1. Open **Conformance of Processes and Goals**.
2. Select **CSL View Model**, **Goal View Model**, **Process View Model**, **Norm View Model**, or **DCR View Model**.
3. Click **Browse** and select the corresponding model file.
4. Click **Open** to compile and display the model.

### Check model conformance

1. Select **Conformance Checking**.
2. Choose the **CSL state model** (`.csl`).
3. Choose the **BPMN process** (`.bpmn2` or `.bpmn`).
4. Choose the **iStar requirements** (`.istar`).
5. Click **Verify conformance**.

The result view reports the conformance verdict and risk level. When a violation is found, its state and failing process checkpoint can be inspected from the result tabs.

### Evaluate CSL state

1. Select **CSL State View**.
2. Choose the **CSL state model** (`.csl`).
3. Choose the **State snapshot** (`.aol`).
4. Click **Evaluate** to check OCL invariants directly over the CSL state.

## Troubleshooting

- **The plugin menu is missing:** verify that `goal-7.1.1-complete.jar` is directly inside `<USE_HOME>/lib/plugins/`, remove any simultaneous `goal-7.1.1.jar`, and restart USE.
- **`UnsupportedClassVersionError`:** run USE with JDK 21.
- **USE modules are missing during the build:** run `git submodule update --init --recursive`, then rebuild from the repository root.
- **Maven cannot resolve a dependency:** check the network connection and confirm that the files under `pluginClone/validator/lib/` are present.
