
import courses._
import BestChoice._

best 
// res0: Set[Schedule] = HashSet(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Introduction to Tilings", code = "MA 237", instructor = "Subhojoy Gupta") -> MWF(
//         times = "11:00 - 12:00"
//       ),
//       Course(
//         name = "Fourier Analysis",
//         code = "MA 326",
//         instructor = "Kalachand Shuin / E. K. Narayanan"
//       ) -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Stochastic Processes", code = "MA 362", instructor = "Manjunath Krishnapur") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(
//         name = "Regularity in the Calculus of Variations",
//         code = "MA 374A",
//         instructor = "Swarnendu Sil"
//       ) -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Linear Algebraic Groups", code = "MA 379", instructor = "Radhika Ganapathy") -> TuTh(
//         times = "8:30 - 10:00"
//       ),
//       Course(
//         name = "Representation Theory of Finite Groups",
//         code = "MA 220",
//         instructor = "R. Venkatesh"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(
//         name = "Techniques in discrete probability",
//         code = "MA 394",
//         instructor = "Riddhipratim Basu"
//       ) -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Introduction to Stochastic Processes",
//         code = "MA 262",
//         instructor = "Arvind Ayyer"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(
//         name = "Introduction to Differentiable Manifolds",
//         code = "MA 235",
//         instructor = "Subhojoy Gupta"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Measure & Integration", code = "MA 222", instructor = "Harish Seshadri") -> MWF(
//         times = "2:00 - 3:00"
//       ),
//       Course(name = "Advanced Functional Analysis", code = "MA 340", instructor = "E. K. Narayanan") -> MWF(
//         times = "11:00 - 12:00"
//       ),
//       Course(name = "Topics in Measure Theory", code = "MA 222A", instructor = "Arka Mallick") -> TuTh(
// ...
best.size
// res1: Int = 28

bestSW
// res2: Set[Schedule] = HashSet(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Introduction to Tilings", code = "MA 237", instructor = "Subhojoy Gupta") -> MWF(
//         times = "11:00 - 12:00"
//       ),
//       Course(
//         name = "Fourier Analysis",
//         code = "MA 326",
//         instructor = "Kalachand Shuin / E. K. Narayanan"
//       ) -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Stochastic Processes", code = "MA 362", instructor = "Manjunath Krishnapur") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(
//         name = "Regularity in the Calculus of Variations",
//         code = "MA 374A",
//         instructor = "Swarnendu Sil"
//       ) -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Linear Algebraic Groups", code = "MA 379", instructor = "Radhika Ganapathy") -> TuTh(
//         times = "8:30 - 10:00"
//       ),
//       Course(
//         name = "Representation Theory of Finite Groups",
//         code = "MA 220",
//         instructor = "R. Venkatesh"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(
//         name = "Techniques in discrete probability",
//         code = "MA 394",
//         instructor = "Riddhipratim Basu"
//       ) -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Introduction to Stochastic Processes",
//         code = "MA 262",
//         instructor = "Arvind Ayyer"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(
//         name = "Introduction to Differentiable Manifolds",
//         code = "MA 235",
//         instructor = "Subhojoy Gupta"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Measure & Integration", code = "MA 222", instructor = "Harish Seshadri") -> MWF(
//         times = "3:00 - 4:00"
//       ),
//       Course(name = "Advanced Functional Analysis", code = "MA 340", instructor = "E. K. Narayanan") -> MWF(
//         times = "11:00 - 12:00"
//       ),
//       Course(name = "Topics in Measure Theory", code = "MA 222A", instructor = "Arka Mallick") -> TuTh(
// ...
bestSW.size
// res3: Int = 4
bestSW.map(_.clashes.size)
// res4: Set[Int] = HashSet(20, 19)
val commonClashes = bestSW.map(_.clashes).reduce(_ intersect _)
// commonClashes: Set[(Course, Course)] = HashSet(
//   (
//     Course(name = "Lie Groups and Lie Algebras", code = "MA 305", instructor = "Muna Naik"),
//     Course(
//       name = "Topics in Finite Element Method",
//       code = "MA 347A",
//       instructor = "Thirupathi Gudi"
//     )
//   ),
//   (
//     Course(name = "Analysis III", code = "MA 321", instructor = "A. K. Nandakumaran"),
//     Course(
//       name = "Fourier Analysis",
//       code = "MA 326",
//       instructor = "Kalachand Shuin / E. K. Narayanan"
//     )
//   ),
//   (
//     Course(name = "Topics in Measure Theory", code = "MA 222A", instructor = "Arka Mallick"),
//     Course(
//       name = "Topics in Finite Element Method",
//       code = "MA 347A",
//       instructor = "Thirupathi Gudi"
//     )
//   ),
//   (
//     Course(name = "Stochastic Processes", code = "MA 362", instructor = "Manjunath Krishnapur"),
//     Course(
//       name = "Regularity in the Calculus of Variations",
//       code = "MA 374A",
//       instructor = "Swarnendu Sil"
//     )
//   ),
//   (
//     Course(
//       name = "Representation Theory of Finite Groups",
//       code = "MA 220",
//       instructor = "R. Venkatesh"
//     ),
//     Course(
//       name = "Introduction to Stochastic Processes",
//       code = "MA 262",
//       instructor = "Arvind Ayyer"
//     )
//   ),
//   (
//     Course(name = "Introduction to Tilings", code = "MA 237", instructor = "Subhojoy Gupta"),
//     Course(name = "Advanced Functional Analysis", code = "MA 340", instructor = "E. K. Narayanan")
//   ),
// ...
commonClashes.size
// res5: Int = 16
val minClashSize = bestSW.map(_.clashes.size).min
// minClashSize: Int = 19
val minClashes = bestSW.filter(_.clashes.size == minClashSize).toVector
// minClashes: Vector[Schedule] = Vector(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Introduction to Tilings", code = "MA 237", instructor = "Subhojoy Gupta") -> MWF(
//         times = "11:00 - 12:00"
//       ),
//       Course(
//         name = "Fourier Analysis",
//         code = "MA 326",
//         instructor = "Kalachand Shuin / E. K. Narayanan"
//       ) -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Stochastic Processes", code = "MA 362", instructor = "Manjunath Krishnapur") -> TuTh(
//         times = "2:00 - 3:30"
//       ),
//       Course(
//         name = "Regularity in the Calculus of Variations",
//         code = "MA 374A",
//         instructor = "Swarnendu Sil"
//       ) -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Linear Algebraic Groups", code = "MA 379", instructor = "Radhika Ganapathy") -> TuTh(
//         times = "8:30 - 10:00"
//       ),
//       Course(
//         name = "Representation Theory of Finite Groups",
//         code = "MA 220",
//         instructor = "R. Venkatesh"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(
//         name = "Techniques in discrete probability",
//         code = "MA 394",
//         instructor = "Riddhipratim Basu"
//       ) -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Introduction to Stochastic Processes",
//         code = "MA 262",
//         instructor = "Arvind Ayyer"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(
//         name = "Introduction to Differentiable Manifolds",
//         code = "MA 235",
//         instructor = "Subhojoy Gupta"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Measure & Integration", code = "MA 222", instructor = "Harish Seshadri") -> MWF(
//         times = "2:00 - 3:00"
//       ),
//       Course(name = "Advanced Functional Analysis", code = "MA 340", instructor = "E. K. Narayanan") -> MWF(
//         times = "11:00 - 12:00"
//       ),
//       Course(name = "Topics in Measure Theory", code = "MA 222A", instructor = "Arka Mallick") -> TuTh(
// ...
minClashes.size
// res6: Int = 2
// minClashes(0).diff(minClashes(1))
val chosen = minClashes(0)
// chosen: Schedule = Schedule(
//   sch = HashMap(
//     Course(name = "Introduction to Tilings", code = "MA 237", instructor = "Subhojoy Gupta") -> MWF(
//       times = "11:00 - 12:00"
//     ),
//     Course(
//       name = "Fourier Analysis",
//       code = "MA 326",
//       instructor = "Kalachand Shuin / E. K. Narayanan"
//     ) -> TuTh(times = "10:00 - 11:30"),
//     Course(name = "Stochastic Processes", code = "MA 362", instructor = "Manjunath Krishnapur") -> TuTh(
//       times = "2:00 - 3:30"
//     ),
//     Course(
//       name = "Regularity in the Calculus of Variations",
//       code = "MA 374A",
//       instructor = "Swarnendu Sil"
//     ) -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Linear Algebraic Groups", code = "MA 379", instructor = "Radhika Ganapathy") -> TuTh(
//       times = "8:30 - 10:00"
//     ),
//     Course(
//       name = "Representation Theory of Finite Groups",
//       code = "MA 220",
//       instructor = "R. Venkatesh"
//     ) -> TuTh(times = "3:30 - 5: 00"),
//     Course(
//       name = "Techniques in discrete probability",
//       code = "MA 394",
//       instructor = "Riddhipratim Basu"
//     ) -> MWF(times = "2:00 - 3:00"),
//     Course(
//       name = "Introduction to Stochastic Processes",
//       code = "MA 262",
//       instructor = "Arvind Ayyer"
//     ) -> TuTh(times = "3:30 - 5: 00"),
//     Course(
//       name = "Introduction to Differentiable Manifolds",
//       code = "MA 235",
//       instructor = "Subhojoy Gupta"
//     ) -> TuTh(times = "3:30 - 5: 00"),
//     Course(name = "Measure & Integration", code = "MA 222", instructor = "Harish Seshadri") -> MWF(
//       times = "2:00 - 3:00"
//     ),
//     Course(name = "Advanced Functional Analysis", code = "MA 340", instructor = "E. K. Narayanan") -> MWF(
//       times = "11:00 - 12:00"
//     ),
//     Course(name = "Topics in Measure Theory", code = "MA 222A", instructor = "Arka Mallick") -> TuTh(
//       times = "11:30 - 1:00"
// ...
chosen.sch.size
// res7: Int = 20

chosen.tsv
// res8: String = """MA 213	Algebra II	R. Venkatesh	Tue, Thu	2:00 - 3:30
// MA 218	Number Theory	Shaunak Deo	Tue, Thu	10:00 - 11:30
// MA 220	Representation Theory of Finite Groups	R. Venkatesh	Tue, Thu	3:30 - 5: 00
// MA 222	Measure & Integration	Harish Seshadri	Mon, Wed, Fri	2:00 - 3:00
// MA 222A	Topics in Measure Theory	Arka Mallick	Tue, Thu	11:30 - 1:00
// MA 224	Complex Analysis	Gautam Bharali	Mon, Wed, Fri	3:00 - 4:00
// MA 235	Introduction to Differentiable Manifolds	Subhojoy Gupta	Tue, Thu	3:30 - 5: 00
// MA 237	Introduction to Tilings	Subhojoy Gupta	Mon, Wed, Fri	11:00 - 12:00
// MA 241	Ordinary Differential Equations	Vamsi Pritham Pingali	Mon, Wed, Fri	11:00 - 12:00
// MA 262	Introduction to Stochastic Processes	Arvind Ayyer	Tue, Thu	3:30 - 5: 00
// MA 305	Lie Groups and Lie Algebras	Muna Naik	Tue, Thu	11:30 - 1:00
// MA 321	Analysis III	A. K. Nandakumaran	Tue, Thu	10:00 - 11:30
// MA 326	Fourier Analysis	Kalachand Shuin / E. K. Narayanan	Tue, Thu	10:00 - 11:30
// MA 340	Advanced Functional Analysis	E. K. Narayanan	Mon, Wed, Fri	11:00 - 12:00
// MA 347A	Topics in Finite Element Method	Thirupathi Gudi	Tue, Thu	11:30 - 1:00
// MA 362	Stochastic Processes	Manjunath Krishnapur	Tue, Thu	2:00 - 3:30
// MA 366A	Introduction to Stochastic Finance	Srikanth K. Iyer	Tue, Thu	11:30 - 1:00
// MA 374A	Regularity in the Calculus of Variations	Swarnendu Sil	Tue, Thu	2:00 - 3:30
// MA 379	Linear Algebraic Groups	Radhika Ganapathy	Tue, Thu	8:30 - 10:00
// MA 394	Techniques in discrete probability	Riddhipratim Basu	Mon, Wed, Fri	2:00 - 3:00
// """
chosen.clashes.mkString("\n")
// res9: String = """(Course(Measure & Integration,MA 222,Harish Seshadri),Course(Techniques in discrete probability,MA 394,Riddhipratim Basu))
// (Course(Lie Groups and Lie Algebras,MA 305,Muna Naik),Course(Topics in Finite Element Method,MA 347A,Thirupathi Gudi))
// (Course(Analysis III,MA 321,A. K. Nandakumaran),Course(Fourier Analysis,MA 326,Kalachand Shuin / E. K. Narayanan))
// (Course(Topics in Measure Theory,MA 222A,Arka Mallick),Course(Topics in Finite Element Method,MA 347A,Thirupathi Gudi))
// (Course(Stochastic Processes,MA 362,Manjunath Krishnapur),Course(Regularity in the Calculus of Variations,MA 374A,Swarnendu Sil))
// (Course(Number Theory,MA 218,Shaunak Deo),Course(Fourier Analysis,MA 326,Kalachand Shuin / E. K. Narayanan))
// (Course(Representation Theory of Finite Groups,MA 220,R. Venkatesh),Course(Introduction to Stochastic Processes,MA 262,Arvind Ayyer))
// (Course(Introduction to Tilings,MA 237,Subhojoy Gupta),Course(Advanced Functional Analysis,MA 340,E. K. Narayanan))
// (Course(Number Theory,MA 218,Shaunak Deo),Course(Analysis III,MA 321,A. K. Nandakumaran))
// (Course(Topics in Measure Theory,MA 222A,Arka Mallick),Course(Lie Groups and Lie Algebras,MA 305,Muna Naik))
// (Course(Lie Groups and Lie Algebras,MA 305,Muna Naik),Course(Introduction to Stochastic Finance,MA 366A,Srikanth K. Iyer))
// (Course(Ordinary Differential Equations,MA 241,Vamsi Pritham Pingali),Course(Advanced Functional Analysis,MA 340,E. K. Narayanan))
// (Course(Topics in Measure Theory,MA 222A,Arka Mallick),Course(Introduction to Stochastic Finance,MA 366A,Srikanth K. Iyer))
// (Course(Topics in Finite Element Method,MA 347A,Thirupathi Gudi),Course(Introduction to Stochastic Finance,MA 366A,Srikanth K. Iyer))
// (Course(Introduction to Differentiable Manifolds,MA 235,Subhojoy Gupta),Course(Introduction to Stochastic Processes,MA 262,Arvind Ayyer))
// (Course(Algebra II,MA 213,R. Venkatesh),Course(Stochastic Processes,MA 362,Manjunath Krishnapur))
// (Course(Algebra II,MA 213,R. Venkatesh),Course(Regularity in the Calculus of Variations,MA 374A,Swarnendu Sil))
// (Course(Representation Theory of Finite Groups,MA 220,R. Venkatesh),Course(Introduction to Differentiable Manifolds,MA 235,Subhojoy Gupta))
// (Course(Introduction to Tilings,MA 237,Subhojoy Gupta),Course(Ordinary Differential Equations,MA 241,Vamsi Pritham Pingali))"""
StudentChoices
  .strongClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res10: Vector[((String, String), String)] = Vector(
//   (("Measure & Integration", "Techniques in discrete probability"), "Naman Mishra, Srujan Patil"),
//   (("Stochastic Processes", "Regularity in the Calculus of Variations"), "Nilaksh Pundir"),
//   (
//     ("Representation Theory of Finite Groups", "Introduction to Stochastic Processes"),
//     "Jasoliya Mohit"
//   ),
//   (("Topics in Measure Theory", "Introduction to Stochastic Finance"), "Pratyush Kant"),
//   (("Introduction to Differentiable Manifolds", "Introduction to Stochastic Processes"), "`Fredie"),
//   (
//     ("Representation Theory of Finite Groups", "Introduction to Differentiable Manifolds"),
//     "Anurag Sarkar "
//   )
// )
StudentChoices
  .weakClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res11: Vector[((String, String), String)] = Vector(
//   (
//     ("Measure & Integration", "Techniques in discrete probability"),
//     "Vipul Tejwani , Naman Mishra, Srujan Patil, `Fredie, Ramanan T"
//   ),
//   (
//     ("Stochastic Processes", "Regularity in the Calculus of Variations"),
//     "Nilaksh Pundir, Siddhesh Patil"
//   ),
//   (("Number Theory", "Fourier Analysis"), "Ayon Chowdhury"),
//   (
//     ("Representation Theory of Finite Groups", "Introduction to Stochastic Processes"),
//     "Anurag Sarkar , Jasoliya Mohit, Siddhesh Patil, Satya Ranjan Ray Choudhury "
//   ),
//   (
//     ("Topics in Measure Theory", "Introduction to Stochastic Finance"),
//     "Pratyush Kant, Pradyun, Vipul Tejwani "
//   ),
//   (("Topics in Finite Element Method", "Introduction to Stochastic Finance"), "Siripuru Abhiram"),
//   (
//     ("Introduction to Differentiable Manifolds", "Introduction to Stochastic Processes"),
//     "Sanjay P Mallar, Anurag Sarkar , Dhruv, `Fredie"
//   ),
//   (
//     ("Algebra II", "Stochastic Processes"),
//     "Vipul Tejwani , Naman Mishra, Shreeansh Hota , `Fredie, Siddhesh Patil"
//   ),
//   (("Algebra II", "Regularity in the Calculus of Variations"), "Siddhesh Patil"),
//   (
//     ("Representation Theory of Finite Groups", "Introduction to Differentiable Manifolds"),
//     "Swarnava Chakraborty , Anurag Sarkar , Rashik Das"
//   ),
//   (
//     ("Introduction to Tilings", "Ordinary Differential Equations"),
//     "Omar Muhammad , Shreeansh Hota , Harisrrinivas V"
//   )
// )
chosen.sorted.groupMap(_._2)(_._1)
// res12: Map[Timing, Vector[Course]] = HashMap(
//   TuTh(times = "11:30 - 1:00") -> Vector(
//     Course(name = "Topics in Measure Theory", code = "MA 222A", instructor = "Arka Mallick"),
//     Course(name = "Lie Groups and Lie Algebras", code = "MA 305", instructor = "Muna Naik"),
//     Course(
//       name = "Topics in Finite Element Method",
//       code = "MA 347A",
//       instructor = "Thirupathi Gudi"
//     ),
//     Course(
//       name = "Introduction to Stochastic Finance",
//       code = "MA 366A",
//       instructor = "Srikanth K. Iyer"
//     )
//   ),
//   MWF(times = "11:00 - 12:00") -> Vector(
//     Course(name = "Introduction to Tilings", code = "MA 237", instructor = "Subhojoy Gupta"),
//     Course(
//       name = "Ordinary Differential Equations",
//       code = "MA 241",
//       instructor = "Vamsi Pritham Pingali"
//     ),
//     Course(name = "Advanced Functional Analysis", code = "MA 340", instructor = "E. K. Narayanan")
//   ),
//   TuTh(times = "10:00 - 11:30") -> Vector(
//     Course(name = "Number Theory", code = "MA 218", instructor = "Shaunak Deo"),
//     Course(name = "Analysis III", code = "MA 321", instructor = "A. K. Nandakumaran"),
//     Course(
//       name = "Fourier Analysis",
//       code = "MA 326",
//       instructor = "Kalachand Shuin / E. K. Narayanan"
//     )
//   ),
//   TuTh(times = "2:00 - 3:30") -> Vector(
//     Course(name = "Algebra II", code = "MA 213", instructor = "R. Venkatesh"),
//     Course(name = "Stochastic Processes", code = "MA 362", instructor = "Manjunath Krishnapur"),
//     Course(
//       name = "Regularity in the Calculus of Variations",
//       code = "MA 374A",
//       instructor = "Swarnendu Sil"
//     )
//   ),
//   TuTh(times = "8:30 - 10:00") -> Vector(
//     Course(name = "Linear Algebraic Groups", code = "MA 379", instructor = "Radhika Ganapathy")
//   ),
//   MWF(times = "3:00 - 4:00") -> Vector(
//     Course(name = "Complex Analysis", code = "MA 224", instructor = "Gautam Bharali")
//   ),
//   TuTh(times = "3:30 - 5: 00") -> Vector(
// ...
os.write.over(SavedData.dat / "schedule.tsv", chosen.tsv)
chosen.core1TuTh
// res14: Int = 2
CourseData.core1
// res15: Vector[Course] = Vector(
//   Course(name = "Complex Analysis", code = "MA 224", instructor = "Gautam Bharali"),
//   Course(
//     name = "Ordinary Differential Equations",
//     code = "MA 241",
//     instructor = "Vamsi Pritham Pingali"
//   )
// )
chosen.sch.filter{case (c, t) => (CourseData.core1 ++ CourseData.coreUG).contains(c) && t.isTuTh}
// res16: Map[Course, Timing] = HashMap()
chosen.sch.filter{case (c, t) => CourseData.core2.contains(c) && t.isTuTh}
// res17: Map[Course, Timing] = HashMap()
chosen.sch.filter{case (c, t) => (CourseData.core1 ++ CourseData.coreIntPhD).contains(c) && t.isTuTh}
// res18: Map[Course, Timing] = HashMap(
//   Course(name = "Algebra II", code = "MA 213", instructor = "R. Venkatesh") -> TuTh(times = "2:00 - 3:30"),
//   Course(
//     name = "Introduction to Differentiable Manifolds",
//     code = "MA 235",
//     instructor = "Subhojoy Gupta"
//   ) -> TuTh(times = "3:30 - 5: 00")
// )
BestChoice.sch.worst
// res19: Int = 2
BestChoice.sch.numWorst
// res20: Int = 3