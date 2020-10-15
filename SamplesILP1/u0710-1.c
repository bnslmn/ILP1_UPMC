#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp29;
    ILP_Object ilptmp30;
    ilptmp29 = ILP_FALSE;
    {
      ILP_Object ilptmp31;
      ILP_Object ilptmp32;
      ilptmp31 = ILP_Integer2ILP (710);
      ilptmp32 = ILP_Integer2ILP (2);
      ilptmp30 = ILP_Or (ilptmp31, ilptmp32);
    }
    return ILP_Or (ilptmp29, ilptmp30);
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
