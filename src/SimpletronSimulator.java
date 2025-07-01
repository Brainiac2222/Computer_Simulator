import java.util.Scanner;

public class SimpletronSimulator {
    Scanner input = new Scanner( System.in );

    private final int[] memory = new int[ 100 ];
    private int accumulator = 0;
    private int instructionRegister = 0;
    private int instructionCounter = 0;
    private int operationCode = 0;
    private int operand = 0;

    private boolean isHalted = false;

    public void load(){
        int counter = 0;
        int instruction;

        System.out.println( "*** Welcome to Simpletron! ***" );
        System.out.println( "*** Please enter your program one instruction ***" );
        System.out.println( "*** (or data word) at a time. I will display ***" );
        System.out.println( "*** the location number and a question mark (?) ***" );
        System.out.println( "*** You then type the word for that location. ***" );
        System.out.println( "*** Type -99999 to stop entering your program. ***" );
        instruction = input.nextInt();

        while( instruction != -99999){
            memory[ counter ] = instruction;
            counter++;

            instruction = input.nextInt();
        }
        System.out.println();

        for ( int i = 0; i < counter; i++ )
        {
            System.out.printf( "%02d ? %+05d\n", i, memory[ i ] );
        }

        System.out.println( "\n*** Program loading completed ***" );
    }

    public void run() {
        System.out.println( "*** Program execution begins ***\n\n");


        while ( !isHalted )
        {
            instructionRegister = memory[ instructionCounter ];

            operationCode = instructionRegister / 100;
            operand = instructionRegister % 100;

            switch( operationCode )
            {
                case 10:
                    System.out.print( "Enter an integer: ");
                    int value = input.nextInt();

                    if( value < -9999 || value > 9999 )
                    {
                        System.err.println( "Input out of range. Halting." );
                        isHalted = true;
                    }
                    else
                    {
                        memory[ operand ] = value;
                    }
                    break;

                case 11:
                    System.out.printf( "Output: %+05d\n", memory[ operand ] );
                    break;

                case 20:
                    accumulator = memory[ operand ];
                    break;

                case 21:
                    memory[ operand ] = accumulator;
                    break;

                case 30:
                    accumulator += memory[ operand ];

                    if ( accumulator < -9999 || accumulator > 9999 )
                    {
                        System.out.println( "Accumulator overflow. Halting." );
                        isHalted = true;
                    }
                    break;

                case 31:
                    accumulator -= memory[ operand ];
                    if ( accumulator < -9999 || accumulator > 9999 )
                    {
                        System.out.println( "Accumulator overflow. Halting." );
                        isHalted = true;
                    }
                    break;

                case 32:
                    if ( memory[ operand ] == 0 )
                    {
                        System.err.println( "Error: Division by zero. Halting." );
                        isHalted = true;
                    }
                    accumulator /= memory[ operand ];
                    break;

                case 33:
                    accumulator *= memory[ operand ];
                    break;

                case 40:
                    instructionCounter = operand;
                    continue;

                case 41:
                    if( accumulator < 0 )
                    {
                        instructionCounter = operand;
                        continue;
                    }
                    break;

                case 42:
                    if( accumulator == 0 )
                    {
                        instructionCounter = operand;
                        continue;
                    }
                    break;

                case 43:
                    System.out.println( "\n*** Simpletron execution terminated ***" );
                    isHalted = true;
                    break;

                default:
                    System.err.println( "Fatal Error: Unknown operationCode. Halting." );
                    isHalted = true;
                    break;

            }

            if( !isHalted )
            {
                instructionCounter++;
            }
        }

    }

    public void dump()
    {
        System.out.println( "\n\nREGISTERS: " );
        System.out.printf("%-20s %+05d%n", "accumulator", accumulator);
        System.out.printf("%-20s    %02d%n", "instructionCounter", instructionCounter);
        System.out.printf("%-20s %+05d%n", "instructionRegister", instructionRegister);
        System.out.printf("%-20s    %02d%n", "operationCode", operationCode);
        System.out.printf("%-20s    %02d%n", "operand", operand);

        System.out.println("\nMEMORY:");
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("     %d", i);
        }
        System.out.println();


        for (int i = 0; i < 100; i += 10) {
            System.out.printf("%02d ", i);

            for (int j = 0; j < 10; j++) {
                System.out.printf("%+05d ", memory[i + j]);
            }
            System.out.println();
        }

    }
}
