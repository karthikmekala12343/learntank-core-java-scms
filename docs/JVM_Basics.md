# Basics

> What is JDK, JRE, JVM ?
- JVM :  Java Virtual Machine provides the runtime environment to execute Java bytecode. It interprets the bytecode and translates it into machine-specific instructions.
- JRE : Java Runtime Environment, it combines with JVM, java core classes, and supporting libraries to run a Java application.
- JDK : Java Development Kit , used to create java applications and development tools like the compiler (`javac`), archiver (`jar`).

> What is bytecode ?
- When Java source code (`.java` files) is compiled, it is not compiled directly into machine code specific to your operating system. Instead, it is compiled into **Bytecode** (`.class` files). Bytecode is a set of instructions that looks like machine code but is not specific to any physical processor.

> What does "write once, run anywhere" mean (1–2 short paragraphs) ?
- Java code is compiled into Bytecode rather than native machine code, the same `.class` files can run on any device that has a JVM installed.
- Whether you are on Windows, Linux, or macOS, the JVM interprets the bytecode into the correct native machine instructions for that specific hardware.
- This allows developers to write code once and deploy it anywhere without recompilation.

