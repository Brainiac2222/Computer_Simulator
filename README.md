# Simpletron Computer Simulator in Java

This project is a complete, text-based simulator for the **Simpletron**, a simple virtual computer described in the Deitel & Deitel book series "How to Program". It's a classic computer science exercise designed to illustrate the fundamental principles of computer architecture and machine language.

## About The Simpletron

The Simpletron runs a low-level language called Simpletron Machine Language (SML). It operates on the following core principles:
- **Memory:** A 100-word memory, where each word is a 4-digit signed integer.
- **Stored-Program Concept:** Both instructions and data are stored together in memory.
- **Registers:** It uses a single general-purpose register, the **accumulator**, for all calculations.
- **Fetch-Decode-Execute Cycle:** The simulator faithfully reproduces the core loop that powers all modern computers.

## Features

- **Full SML Instruction Set:** Implements all standard I/O, Load/Store, Arithmetic, and Branching operations.
- **Robust Error Handling:** The simulator gracefully handles errors like invalid opcodes, accumulator overflow, and division by zero.
- **Interactive Program Loading:** Users are prompted to enter their SML program one instruction at a time.
- **Detailed Memory Dump:** After execution, the program prints a formatted view of all registers and the entire contents of memory, making it easy to debug and verify results.

## Getting Started

To run this simulator on your local machine, follow these steps.

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/Brainiac2222/Computer_Simulator.git
    ```

2.  **Navigate to the project directory:**
    ```sh
    cd Computer_Simulator
    ```

3.  **Compile the Java code:**
4.  ```sh
    javac Main.java
    ```

5.  **Run the simulator:**
    ```sh
    java Main
    ```
6.  Follow the on-screen prompts to enter your SML code, and type `-99999` to begin execution.

## SML Opcode Reference

| Opcode | Name       | Description                                  |
| :----- | :--------- | :------------------------------------------- |
| `10`   | READ       | Read a number into a memory location.        |
| `11`   | WRITE      | Write a number from memory to the screen.    |
| `20`   | LOAD       | Load a number from memory into the accumulator.|
| `21`   | STORE      | Store a number from the accumulator into memory.|
| `30`   | ADD        | Add a number from memory to the accumulator. |
| `31`   | SUBTRACT   | Subtract a number from the accumulator.      |
| `32`   | DIVIDE     | Divide the accumulator by a number from memory.|
| `33`   | MULTIPLY   | Multiply the accumulator by a number.        |
| `40`   | BRANCH     | Unconditionally jump to a memory location.   |
| `41`   | BRANCHNEG  | Jump if the accumulator is negative.         |
| `42`   | BRANCHZERO | Jump if the accumulator is zero.             |
| `43`   | HALT       | Terminate program execution.                 |
