using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LAB1
{
    
    public class EISCH2_Scholarship2
    {
        public static void Main(string[] args)
        {
            Reader rd = new Reader();
            StringBuilder sb = new StringBuilder();
            List<Student> list = new List<Student>();
            int n = rd.NextInt();
            for (int i = 0; i < n; i++)
            {
                String name = rd.Next();
                double subject = rd.NextDouble();
                Student student = new Student(name, subject);
                while (subject-- > 0)
                {
                    int grade = rd.NextInt();
                    student.addGrade(grade);            
                }
                list.Add(student);     
            }
            list = list.OrderByDescending(s => s.gpa).ThenBy(s => s.name).ToList();
            int topA = n / 12, topB = n / 3, topC = n / 2;
            for (int i = 0; i < n; i++)
            {   
                if(list[i].gpa > list[topA].gpa)
                {
                    sb.Append(list[i].toString() + "A \n");
                }
                else
                {
                    if (list[i].gpa > list[topB].gpa)
                    {
                        sb.Append(list[i].toString() + "B \n");
                    }
                    else
                    {
                        if (list[i].gpa > list[topC].gpa)
                        {
                            sb.Append(list[i].toString() + "C \n");
                        }
                    }
                }
            }
            Console.WriteLine(sb.ToString());
            Console.ReadKey();

        }     

    }

    public class Student
    {
        public String name;
        public double subject;
        public int score;
        public double totalScore;
        public double gpa;
        public Student(String name, double subject)
        {
            this.name = name;
            this.subject = subject;
        }
        public void addGrade(int grade)
        {
            if (grade < 50)
            {
                this.subject--;
                return;
            }
            else
            {
                this.totalScore += grade;
            } 
            if (this.subject != 0)
            {
                this.gpa = (double)totalScore / this.subject;
            }         
        }
        public String toString()
        {
            return this.name + " " + this.gpa + " ";
        }

    }

    class Reader
    {
        private int index = 0;
        private string[] tokens;
        public string Next()
        {
            while (tokens == null || tokens.Length <= index)
            {
                tokens = Console.ReadLine().Split(new char[] { ' ', '\t' }, StringSplitOptions.RemoveEmptyEntries);
                index = 0;
            }
            return tokens[index++];
        }
        public int NextInt()
        {
            
            return int.Parse(Next());
        }

        public double NextDouble()
        {
            return double.Parse(Next());
        }
    }
}
