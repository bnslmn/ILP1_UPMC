#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp66;
    ILP_Object ilptmp67;
    ilptmp66 = ILP_Integer2ILP (22);
    ilptmp67 = ILP_Integer2ILP (33);
    return ILP_LessThanOrEqual (ilptmp66, ilptmp67);
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
