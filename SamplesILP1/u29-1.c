#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp95;
    ilptmp95 = ILP_Integer2ILP (3);

    {
      ILP_Object x1 = ilptmp95;
      {
	ILP_Object ilptmp96;
	{
	  ILP_Object ilptmp97;
	  ILP_Object ilptmp98;
	  ilptmp97 = x1;
	  ilptmp98 = x1;
	  ilptmp96 = ILP_Plus (ilptmp97, ilptmp98);
	}

	{
	  ILP_Object x2 = ilptmp96;
	  {
	    ILP_Object ilptmp99;
	    ILP_Object ilptmp100;
	    ilptmp99 = x2;
	    ilptmp100 = x2;
	    return ILP_Times (ilptmp99, ilptmp100);
	  }

	}
      }

    }
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
