# CSL naming migration

The project language is **CSL — Composite State Language**. The migration replaces the former ACL name in project-owned Java packages/classes, imports, parser headers, translators, runtime-generated model symbols, plugin action registrations, tests, examples, Ecore/GenModel/Sirius references and documentation.

- `org.vnu.sme.goal.dsl.csl`, `CslModel`, `CslCompiler`, and other `Csl…` classes are the canonical Java names.
- The grammar entry keyword is `csl`; filenames use `.csl`, `.cslboundary`, and `.cslscenario`.
- The metamodel is `csl.ecore`, with package URI `https://vnu.edu.vn/sme/goal/csl/4.0`; the development state package likewise uses `csl` in its URI.
- `.aird`, `.genmodel`, XMI fixtures and example layout references were migrated together.

This is a source/API and persisted-name migration. External consumers must update old Java imports and recompile; external saved models need their old language keyword, filenames and namespace references migrated together. Old preference/layout keys and generated USE identifiers are not automatically aliased. Rebuild the plugin before launching; obsolete build outputs from an earlier build are not source files.

The author's conversation and original PDFs are research evidence and retain their original contents. Third-party USE/plugin implementation names, including unrelated terms such as Oracle, are not renamed. Local design Markdown and uncompressed draw.io sources were updated where applicable; ignored research files remain ignored by Git.

## Validation on 2026-10-06

The goal module was rebuilt from clean output. Plugin action class paths and public Java class/file names resolve after renaming. The same 109 selected tests were run against the migrated source and an isolated `git archive HEAD` baseline:

| Outcome | Baseline | CSL migration |
|---|---:|---:|
| Passed | 36 | 39 |
| Failed assertions | 43 | 44 |
| Errors | 30 | 26 |

No previously passing test became failing. Three previously erroneous tests now pass; one previously erroneous test now reaches a failing assertion. The 70 remaining failing/error cases were also unsuccessful in the baseline. Existing issues include legacy fixture syntax and outdated translator assertions; this naming change does not repair those semantics. The test suite is therefore **not green**.

Reproduce the selected regression run:

```sh
mvn -o -f goal/pom.xml test '-Dtest=*,!CaseStudyEvaluationRunnerTest,!*ConsistencyTest,!*ExampleTest' -Djava.awt.headless=true
```

The research benchmark and whole-case SAT checks are excluded from that 109-test comparison. A broader reactor test invocation also failed in the existing USE GUI test process; it is not counted as a successful validation.

NormML was independently checked using Eclipse EMF/OCL: 19 classifiers, 24 compiled invariants, valid XMI roundtrip, and three negative cases. Its Sirius/GMF representation and GenModel load with their persisted references resolved against the installed EcoreTools definitions. This is programmatic validation, not a claim that the Eclipse GUI was visually inspected.
