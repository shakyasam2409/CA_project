# CA_project

In this project we have implemented RISCV RV32I simulator. This code takes  input from a text file containing the assembly instructions. Each line of the text file may be of one of 3 types:

● A label followed by an instruction

● An instruction

In addition:

● The fields of instruction are comma-separated. An instruction can be one of the following:

○ The opcode must be one of the abbreviations mentioned in the given table.

○ A register can be one of r0, r1, ... r31.

● A label marks a location in the code and must be followed by a colon (:). No spaces are
allowed between label name and colon(:). A label name consists of alphanumeric
characters and underscores. Exactly one space is allowed after “:” and the opcode
mnemonic.
A label followed by the instruction may look like:

mylabel: add r1 r2 r3

We have implemented the following instructions
Instruction Description

1. Load Instructions -  LW - Load word

2. Store Instructions - SW - Store Word

3. Shift Instructions - SLL - Shift Logical left, SRA - Shift Right Arithmetic

4. Ari;thmetic Instructions - ADD – Addition, ADDI - Add Immediate, SUB – Subtraction, LUI - Load Upper Immediate

5. Logical Instructions –  XOR – XOR, OR – OR, AND - AND

6. Branch Instructions – BEQ - Branch Equal to, BNE - Branch Not equal to, BLT - Branch Less than, BGE - Branch greater than equal 

7. Jump and Link Instructions - JALR - Jump and Link Register, JAL - Jump and Link


The Assembler gives a 32-bit binary instruction which is given as input to the simulator.

The simulator decodes and then execute the instruction. It has a main memory as wll as l1 level cache.

simulator has the following functionality :
1. It load the input binary(compiled by your assembler) in the system memory at the
beginning, and then start executing the code at address 0.
2. Fetch instructions from the main memory.
3. Execute them based on the semantics of the fetched instruction.
4. Provide accurate cycle times for each instruction based on the parameters of cache,
main memory, and ALU.
