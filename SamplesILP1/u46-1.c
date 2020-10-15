#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */
ILP_Object print;


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp144;
    {
      ILP_Object ilptmp145;
      ilptmp145 = ILP_String2ILP ("Un, ");
      ilptmp144 = ILP_print (ilptmp145);
    }
    {
      ILP_Object ilptmp146;
      ilptmp146 = ILP_String2ILP ("deux et ");
      ilptmp144 = ILP_print (ilptmp146);
    }
    {
      ILP_Object ilptmp147;
      ilptmp147 = ILP_String2ILP ("trois.");
      ilptmp144 = ILP_print (ilptmp147);
    }
    return ilptmp144;
  }

}

static ILP_Object
ilp_caught_program ()
{
  struct ILP_catcher *current_catcher = ILP_current_catcher;
  struct ILP_catcher new_catcher;

  if (0 == setjmp (new_catcher._jmp_buf))
    {
      ILP_establish_catcher (&new_catcher);
      return ilp_program ();
    };
  return ILP_current_exception;
}

int
main (int argc, char *argv[])
{
  ILP_START_GC;
  ILP_print (ilp_caught_program ());
  ILP_newline ();
  return EXIT_SUCCESS;
}
