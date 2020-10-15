#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp101;
    ILP_Object ilptmp102;
    ilptmp101 = ILP_Integer2ILP (11);
    ilptmp102 = ILP_Integer2ILP (22);

    {
      ILP_Object x1 = ilptmp101;
      ILP_Object y2 = ilptmp102;
      {
	ILP_Object ilptmp103;
	ILP_Object ilptmp104;
	{
	  ILP_Object ilptmp105;
	  ILP_Object ilptmp106;
	  ilptmp105 = x1;
	  ilptmp106 = y2;
	  ilptmp103 = ILP_Plus (ilptmp105, ilptmp106);
	}
	{
	  ILP_Object ilptmp107;
	  ILP_Object ilptmp108;
	  ilptmp107 = x1;
	  ilptmp108 = y2;
	  ilptmp104 = ILP_Times (ilptmp107, ilptmp108);
	}

	{
	  ILP_Object x3 = ilptmp103;
	  ILP_Object y4 = ilptmp104;
	  {
	    ILP_Object ilptmp109;
	    ILP_Object ilptmp110;
	    ilptmp109 = x3;
	    ilptmp110 = y4;
	    return ILP_Times (ilptmp109, ilptmp110);
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
