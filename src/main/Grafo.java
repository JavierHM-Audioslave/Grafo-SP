package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {
	
	private Integer cantNodos;
	private Integer cantAristas;
	private Integer[][] grafo;
	
	public Grafo(Integer cantNodos, Integer cantAristas)
	{
		this.cantNodos = cantNodos;
		this.cantAristas = cantAristas;
		grafo = new Integer[cantNodos][cantNodos];
	}
	
	public Grafo(Integer cantNodos, Integer[][] matAdy)
	{
		this.cantNodos = cantNodos;
		this.grafo = matAdy;
		this.cantAristas = cantNodos*(cantNodos-1); // NOTA: Como al usar este constructor, la matriz de adyacencia ya existe y es pasada por parametro, la cantAristas es un dato irrelevante ya que no voy a tener que cargar el grafo dado que ya esta cargado y pasado por parametro en matAdy. //
	}
	
	public Scanner cargarGrafoNodirigido(Scanner sc)
	{
		for(int i = 0; i<cantNodos; i++)
		{
			for(int j = 0; j<cantNodos; j++)
			{
				if(i!=j)
				{
					grafo[i][j] = 1000000;
				}
				else
				{
					grafo[i][j] = 0;
				}
			}
		}
		
		Integer anterior;
		Integer posterior;
		Integer peso;
		for(int i = 0; i<cantAristas/2; i++)
		{
			anterior = sc.nextInt()-1;
			posterior = sc.nextInt()-1;
			peso = sc.nextInt();
			grafo[anterior][posterior] = peso;
			grafo[posterior][anterior] = peso;
		}
		
		return sc;
	}
	
	
	public void cargarGrafoNoDirigido(ArrayList<String> aux)
	{
		for(int i = 0; i<cantNodos; i++)
		{
			for(int j = 0; j<cantNodos; j++)
			{
				if(i!=j)
				{
					grafo[i][j] = 1000000;
				}
				else
				{
					grafo[i][j] = 0;
				}
			}
		}
		
		String[] auxiliar = new String[3];
		for(int i = 0; i<cantAristas/2; i++)
		{
			auxiliar = aux.get(i).split(" ");
			grafo[Integer.parseInt(auxiliar[0])-1][Integer.parseInt(auxiliar[1])-1] = Integer.parseInt(auxiliar[2]);
			grafo[Integer.parseInt(auxiliar[1])-1][Integer.parseInt(auxiliar[0])-1] = Integer.parseInt(auxiliar[2]);
		}		
	}
	
	
	public void cargarGrafoNoDirigido(String[] aux)
	{
		for(int i = 0; i<cantNodos; i++)
		{
			for(int j = 0; j<cantNodos; j++)
			{
				if(i!=j)
				{
					grafo[i][j] = 1000000;
				}
				else
				{
					grafo[i][j] = 0;
				}
			}
		}
		
		String[] auxiliar = new String[3];
		for(int i = 0; i<cantAristas/2; i++)
		{
			auxiliar = aux[i].split(" ");
			grafo[Integer.parseInt(auxiliar[0])-1][Integer.parseInt(auxiliar[1])-1] = Integer.parseInt(auxiliar[2]);
			grafo[Integer.parseInt(auxiliar[1])-1][Integer.parseInt(auxiliar[0])-1] = Integer.parseInt(auxiliar[2]);
		}		
	}
	
	
	public Scanner cargarGrafo(Scanner sc) // Carga un grafo dirigido. //
	{
		for(int i = 0; i<cantNodos; i++)
		{
			for(int j = 0; j<cantNodos; j++)
			{
				if(i!=j)
				{
					grafo[i][j] = 1000000;
				}
				else
				{
					grafo[i][j] = 0;
				}
			}
		}
		
		try
		{
			for(int i = 0; i<cantAristas; i++)
			{
				grafo[sc.nextInt()-1][sc.nextInt()-1] = sc.nextInt();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		
		return sc;
	}
	
	public void cargarGrafoSinConexiones()
	{
		for(int i = 0; i<cantNodos; i++)
		{
			for(int j = 0; j<cantNodos; j++)
			{
				if(i!=j)
				{
					grafo[i][j] = 1000000;
				}
				else
				{
					grafo[i][j] = 0;
				}
			}
		}
	}
	
	
	public Integer obtenerCantNodos()
	{
		return cantNodos;
	}
	
	
	public Integer[] obtenerFila(Integer fila)
	{
		return grafo[fila];
	}
	
	
	public Integer obtenerLargoDegrafo()
	{
		return grafo.length;
	}
	
	
	public boolean esDistintoA1000000(Integer fila, Integer columna)
	{
		if(grafo[fila][columna]!=1000000 && grafo[fila][columna]!=0)
		{
			return true;
		}
		return false;
	}
	
	
	public Integer obtenerValor(Integer fila, Integer columna)
	{
		return grafo[fila][columna];
	}
	
	public void setValorCelda(Integer fila, Integer columna, Integer valor)
	{
		grafo[fila][columna] = valor;
	}

}
