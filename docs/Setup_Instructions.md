# Instructions :

JDK version : Java 21.0.2 LTS

# Explaination :

- Using (javac), Java compiler converts your human-readable code into bytecode (a .class file).
- When you run the program using java HelloWorld, the JVM (Java Virtual Machine) loads this bytecode. 
- The ClassLoader subsystem brings the .class file into memory, the Bytecode Verifier checks it for security issues, and then the Execution Engine (using the JIT compiler) converts the bytecode into native machine code specific to your operating system.
- The System.out.println() call executes through Java's core libraries (part of JRE), which interact with your operating system to display "Hello World" on your screen. Finally, the JVM cleans up memory and terminates the program.
- This entire process showcases Java's platform independence—the same bytecode runs unchanged on Windows, macOS, or Linux, with the JVM handling the platform-specific translations.
 