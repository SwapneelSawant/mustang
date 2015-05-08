
package org.ateam.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/ <br>
 * https://www.hackerrank.com/challenges/rust-murderer <br>
 * this is implemented with weightless graph <br>
 * this is opposite of path <br>
 * if path exist than it not to be considered<br>
 * 
 */
public class Dijkstra
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int s = 0; s < testcase; s++)
		{
			/**
			 * ################################ add edges ###################################################
			 */
			int vertices = sc.nextInt();
			int edges = sc.nextInt();
			List<ArrayList<Integer>> relatiosnhip = new ArrayList<ArrayList<Integer>>(vertices);
			for(int i = 0; i < vertices; i++)
			{
				relatiosnhip.add(null);
			}

			for(int i = 0; i < edges; i++)
			{
				int x = sc.nextInt();
				int y = sc.nextInt();
				add(relatiosnhip, x, y);
				add(relatiosnhip, y, x);
			}
			/**
			 * ###################################################################################
			 */
			for(int i = 0; i < vertices; i++)
			{
				ArrayList<Integer> arrayList = relatiosnhip.get(i);
				if(arrayList != null)
					Collections.sort(arrayList);
			}

			int startingNode = sc.nextInt() - 1;
			int[] distance = new int[vertices];

			// sorted on distance
			// passing distance to it to optimize comparator
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10, new Comp(distance));

			Set<Integer> visited = new HashSet<Integer>();

			distance[startingNode] = 0;
			queue.add(startingNode);
			int calc = 1;
			int index;
			ArrayList<Integer> relSet;
			int size;
			int j;
			while(queue.size() != 0 && calc < vertices)
			{
				index = queue.poll();
				if(visited.contains(index))
					continue;

				visited.add(index);

				relSet = relatiosnhip.get(index);
				if(relSet == null)
				{
					for(j = 0; j < vertices; j++)
					{
						if(distance[j] == 0 && j != index)
						{
							distance[j] = distance[index] + 1;
							calc++;
							queue.add(j);
						}
					}
				}
				else
				{
					size = relSet.size();
					int min = relSet.get(0);
					int max;
					for(j = 0; j < min; j++)
					{
						if(distance[j] == 0 && j != index)
						{
							distance[j] = distance[index] + 1;
							calc++;
							queue.add(j);
						}
					}

					for(j = 1; j < size; j++)
					{
						max = relSet.get(j);
						for(int k = min + 1; k < max; k++)
						{
							if(distance[k] == 0 && k != index)
							{
								distance[k] = distance[index] + 1;
								calc++;
								queue.add(k);
							}
						}
						min = max;
					}

					for(j = min + 1; j < vertices; j++)
					{
						if(distance[j] == 0 && j != index)
						{
							distance[j] = distance[index] + 1;
							calc++;
							queue.add(j);
						}
					}

				}

			}
			for(int i = 0; i < distance.length; i++)
			{
				if(i == startingNode)
					continue;
				System.out.print(distance[i] + " ");
			}
			System.out.println();
		}
	}

	private static void add(List<ArrayList<Integer>> relatiosnhip, int x, int y)
	{
		ArrayList<Integer> rel = relatiosnhip.get(x - 1);
		if(rel == null)
		{
			rel = new ArrayList<Integer>();
			relatiosnhip.remove(x - 1);
			relatiosnhip.add(x - 1, rel);
		}
		rel.add(y - 1);
	}

	private static class Comp implements Comparator<Integer>
	{

		int[]	distance;

		public Comp(int[] distance)
		{
			super();
			this.distance = distance;
		}

		@Override
		public int compare(Integer o1, Integer o2)
		{
			if(distance[o1] == distance[o2])
				return 0;

			return distance[o1] > distance[o2] ? 1 : -1;

		}

	}
}