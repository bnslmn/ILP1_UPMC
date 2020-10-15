#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */
ILP_Object pi;


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp129;
    ILP_Object ilptmp130;
    ilptmp129 = ILP_PI;
    ilptmp130 = ILP_Float2ILP (0.1415926535);
    return ILP_Minus (ilptmp129, ilptmp130);
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
