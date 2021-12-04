
import courses._
import BestChoice._

best
// res0: Set[Schedule] = HashSet(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Topics: Percolation", code = "MA 390", instructor = "Sanchayan Sen") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Introduction to Differentiable Manifolds", code = "MA 235", instructor = "Ved Datar") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Topics in Complex Analysis", code = "MA 324", instructor = "Purvi Gupta") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Coxeter Groups", code = "MA 386", instructor = "R. Venkatesh") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Topics in Harmonic Analysis II", code = "MA 322", instructor = "Thangavelu") -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Ordinary Differential Equations", code = "MA 241", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Topics in Geometric Topology: Geometric structures",
//         code = "MA 355",
//         instructor = "Subhojoy Gupta"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Algebraic Geometry", code = "MA 308", instructor = "Abhishek Banerjee") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Algebra II", code = "MA 213", instructor = "Shaunak Deo") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Algebraic Topology", code = "MA 332", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//       Course(
//         name = "Class field theory: a course in arithmetic geometry",
//         code = "MA 356",
//         instructor = "Amalendu Krishna"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Analysis III", code = "MA 321", instructor = "Swarnendu Sil") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Complex Analysis", code = "MA 224", instructor = "E. K. Narayanan") -> MWF(times = "9:00 - 10:00"),
//       Course(name = "Measure & Integration", code = "MA 222", instructor = "Manjunath Krishnapur") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Stochastic Finance", code = "MA 263", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00")
//     )
//   ),
//   Schedule(
//     sch = HashMap(
//       Course(name = "Topics: Percolation", code = "MA 390", instructor = "Sanchayan Sen") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Introduction to Differentiable Manifolds", code = "MA 235", instructor = "Ved Datar") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Topics in Complex Analysis", code = "MA 324", instructor = "Purvi Gupta") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Coxeter Groups", code = "MA 386", instructor = "R. Venkatesh") -> TuTh(times = "3:30 - 5: 00"),
// ...
best.size
// res1: Int = 8

bestSW
// res2: Set[Schedule] = HashSet(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Topics: Percolation", code = "MA 390", instructor = "Sanchayan Sen") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Introduction to Differentiable Manifolds", code = "MA 235", instructor = "Ved Datar") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Topics in Complex Analysis", code = "MA 324", instructor = "Purvi Gupta") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Coxeter Groups", code = "MA 386", instructor = "R. Venkatesh") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Topics in Harmonic Analysis II", code = "MA 322", instructor = "Thangavelu") -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Ordinary Differential Equations", code = "MA 241", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Topics in Geometric Topology: Geometric structures",
//         code = "MA 355",
//         instructor = "Subhojoy Gupta"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Algebraic Geometry", code = "MA 308", instructor = "Abhishek Banerjee") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Algebra II", code = "MA 213", instructor = "Shaunak Deo") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Algebraic Topology", code = "MA 332", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//       Course(
//         name = "Class field theory: a course in arithmetic geometry",
//         code = "MA 356",
//         instructor = "Amalendu Krishna"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Analysis III", code = "MA 321", instructor = "Swarnendu Sil") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Complex Analysis", code = "MA 224", instructor = "E. K. Narayanan") -> MWF(times = "9:00 - 10:00"),
//       Course(name = "Measure & Integration", code = "MA 222", instructor = "Manjunath Krishnapur") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Stochastic Finance", code = "MA 263", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00")
//     )
//   ),
//   Schedule(
//     sch = HashMap(
//       Course(name = "Topics: Percolation", code = "MA 390", instructor = "Sanchayan Sen") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Introduction to Differentiable Manifolds", code = "MA 235", instructor = "Ved Datar") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Topics in Complex Analysis", code = "MA 324", instructor = "Purvi Gupta") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Coxeter Groups", code = "MA 386", instructor = "R. Venkatesh") -> TuTh(times = "3:30 - 5: 00"),
// ...
bestSW.size
// res3: Int = 3
bestSW.map(_.clashes.size)
// res4: Set[Int] = HashSet(13, 17, 15)
val commonClashes = bestSW.map(_.clashes).reduce(_ intersect _)
// commonClashes: Set[(Course, Course)] = HashSet(
//   (
//     Course(name = "Introduction to Differentiable Manifolds", code = "MA 235", instructor = "Ved Datar"),
//     Course(name = "Topics: Percolation", code = "MA 390", instructor = "Sanchayan Sen")
//   ),
//   (
//     Course(name = "Measure & Integration", code = "MA 222", instructor = "Manjunath Krishnapur"),
//     Course(name = "Coxeter Groups", code = "MA 386", instructor = "R. Venkatesh")
//   ),
//   (
//     Course(name = "Topics in Geometric Topology: Geometric structures", code = "MA 355", instructor = "Subhojoy Gupta"),
//     Course(name = "Coxeter Groups", code = "MA 386", instructor = "R. Venkatesh")
//   ),
//   (
//     Course(name = "Introduction to Differentiable Manifolds", code = "MA 235", instructor = "Ved Datar"),
//     Course(name = "Algebraic Geometry", code = "MA 308", instructor = "Abhishek Banerjee")
//   ),
//   (
//     Course(name = "Measure & Integration", code = "MA 222", instructor = "Manjunath Krishnapur"),
//     Course(name = "Topics in Geometric Topology: Geometric structures", code = "MA 355", instructor = "Subhojoy Gupta")
//   ),
//   (
//     Course(name = "Measure & Integration", code = "MA 222", instructor = "Manjunath Krishnapur"),
//     Course(
//       name = "Class field theory: a course in arithmetic geometry",
//       code = "MA 356",
//       instructor = "Amalendu Krishna"
//     )
//   ),
//   (
//     Course(name = "Topics in Geometric Topology: Geometric structures", code = "MA 355", instructor = "Subhojoy Gupta"),
//     Course(
//       name = "Class field theory: a course in arithmetic geometry",
//       code = "MA 356",
//       instructor = "Amalendu Krishna"
//     )
//   ),
//   (
//     Course(name = "Algebraic Geometry", code = "MA 308", instructor = "Abhishek Banerjee"),
//     Course(name = "Topics: Percolation", code = "MA 390", instructor = "Sanchayan Sen")
//   ),
//   (
//     Course(name = "Stochastic Finance", code = "MA 263", instructor = "Srikanth Iyer"),
//     Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Soumya Das")
//   ),
//   (
//     Course(
//       name = "Class field theory: a course in arithmetic geometry",
//       code = "MA 356",
// ...
commonClashes.size
// res5: Int = 10
val minClashSize = bestSW.map(_.clashes.size).min
// minClashSize: Int = 13
val minClashes = bestSW.filter(_.clashes.size == minClashSize).toVector
// minClashes: Vector[Schedule] = Vector(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Topics: Percolation", code = "MA 390", instructor = "Sanchayan Sen") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Introduction to Differentiable Manifolds", code = "MA 235", instructor = "Ved Datar") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Topics in Complex Analysis", code = "MA 324", instructor = "Purvi Gupta") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Coxeter Groups", code = "MA 386", instructor = "R. Venkatesh") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Topics in Harmonic Analysis II", code = "MA 322", instructor = "Thangavelu") -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Ordinary Differential Equations", code = "MA 241", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Topics in Geometric Topology: Geometric structures",
//         code = "MA 355",
//         instructor = "Subhojoy Gupta"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Algebraic Geometry", code = "MA 308", instructor = "Abhishek Banerjee") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Algebra II", code = "MA 213", instructor = "Shaunak Deo") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Algebraic Topology", code = "MA 332", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//       Course(
//         name = "Class field theory: a course in arithmetic geometry",
//         code = "MA 356",
//         instructor = "Amalendu Krishna"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Analysis III", code = "MA 321", instructor = "Swarnendu Sil") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Complex Analysis", code = "MA 224", instructor = "E. K. Narayanan") -> MWF(times = "9:00 - 10:00"),
//       Course(name = "Measure & Integration", code = "MA 222", instructor = "Manjunath Krishnapur") -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Stochastic Finance", code = "MA 263", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00")
//     )
//   )
// )
minClashes.size
// res6: Int = 1
// minClashes(0).diff(minClashes(1))
val chosen = minClashes(0)
// chosen: Schedule = Schedule(
//   sch = HashMap(
//     Course(name = "Topics: Percolation", code = "MA 390", instructor = "Sanchayan Sen") -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Introduction to Differentiable Manifolds", code = "MA 235", instructor = "Ved Datar") -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Topics in Complex Analysis", code = "MA 324", instructor = "Purvi Gupta") -> TuTh(times = "10:00 - 11:30"),
//     Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Soumya Das") -> TuTh(times = "11:30 - 1:00"),
//     Course(name = "Coxeter Groups", code = "MA 386", instructor = "R. Venkatesh") -> TuTh(times = "3:30 - 5: 00"),
//     Course(name = "Topics in Harmonic Analysis II", code = "MA 322", instructor = "Thangavelu") -> MWF(times = "10:00 - 11:00"),
//     Course(name = "Ordinary Differential Equations", code = "MA 241", instructor = "Harish Seshadri") -> MWF(times = "2:00 - 3:00"),
//     Course(name = "Topics in Geometric Topology: Geometric structures", code = "MA 355", instructor = "Subhojoy Gupta") -> TuTh(
//       times = "3:30 - 5: 00"
//     ),
//     Course(name = "Algebraic Geometry", code = "MA 308", instructor = "Abhishek Banerjee") -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Algebra II", code = "MA 213", instructor = "Shaunak Deo") -> MWF(times = "11:00 - 12:00"),
//     Course(name = "Algebraic Topology", code = "MA 332", instructor = "Siddhartha Gadgil") -> TuTh(times = "8:30 - 10:00"),
//     Course(
//       name = "Class field theory: a course in arithmetic geometry",
//       code = "MA 356",
//       instructor = "Amalendu Krishna"
//     ) -> TuTh(times = "3:30 - 5: 00"),
//     Course(name = "Analysis III", code = "MA 321", instructor = "Swarnendu Sil") -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Complex Analysis", code = "MA 224", instructor = "E. K. Narayanan") -> MWF(times = "9:00 - 10:00"),
//     Course(name = "Measure & Integration", code = "MA 222", instructor = "Manjunath Krishnapur") -> TuTh(times = "3:30 - 5: 00"),
//     Course(name = "Stochastic Finance", code = "MA 263", instructor = "Srikanth Iyer") -> TuTh(times = "11:30 - 1:00")
//   )
// )
chosen.sch.size
// res7: Int = 16

chosen.tsv
// res8: String = """MA 213	Algebra II	Shaunak Deo	Mon, Wed, Fri	11:00 - 12:00
// MA 222	Measure & Integration	Manjunath Krishnapur	Tue, Thu	3:30 - 5: 00
// MA 224	Complex Analysis	E. K. Narayanan	Mon, Wed, Fri	9:00 - 10:00
// MA 235	Introduction to Differentiable Manifolds	Ved Datar	Tue, Thu	2:00 - 3:30
// MA 241	Ordinary Differential Equations	Harish Seshadri	Mon, Wed, Fri	2:00 - 3:00
// MA 263	Stochastic Finance	Srikanth Iyer	Tue, Thu	11:30 - 1:00
// MA 308	Algebraic Geometry	Abhishek Banerjee	Tue, Thu	2:00 - 3:30
// MA 313	Algebraic Number Theory	Soumya Das	Tue, Thu	11:30 - 1:00
// MA 321	Analysis III	Swarnendu Sil	Tue, Thu	2:00 - 3:30
// MA 322	Topics in Harmonic Analysis II	Thangavelu	Mon, Wed, Fri	10:00 - 11:00
// MA 324	Topics in Complex Analysis	Purvi Gupta	Tue, Thu	10:00 - 11:30
// MA 332	Algebraic Topology	Siddhartha Gadgil	Tue, Thu	8:30 - 10:00
// MA 355	Topics in Geometric Topology: Geometric structures	Subhojoy Gupta	Tue, Thu	3:30 - 5: 00
// MA 356	Class field theory: a course in arithmetic geometry	Amalendu Krishna	Tue, Thu	3:30 - 5: 00
// MA 386	Coxeter Groups	R. Venkatesh	Tue, Thu	3:30 - 5: 00
// MA 390	Topics: Percolation	Sanchayan Sen	Tue, Thu	2:00 - 3:30
// """
chosen.clashes.mkString("\n")
// res9: String = """(Course(Algebraic Geometry,MA 308,Abhishek Banerjee),Course(Analysis III,MA 321,Swarnendu Sil))
// (Course(Introduction to Differentiable Manifolds,MA 235,Ved Datar),Course(Topics: Percolation,MA 390,Sanchayan Sen))
// (Course(Measure & Integration,MA 222,Manjunath Krishnapur),Course(Coxeter Groups,MA 386,R. Venkatesh))
// (Course(Introduction to Differentiable Manifolds,MA 235,Ved Datar),Course(Analysis III,MA 321,Swarnendu Sil))
// (Course(Introduction to Differentiable Manifolds,MA 235,Ved Datar),Course(Algebraic Geometry,MA 308,Abhishek Banerjee))
// (Course(Measure & Integration,MA 222,Manjunath Krishnapur),Course(Topics in Geometric Topology: Geometric structures,MA 355,Subhojoy Gupta))
// (Course(Measure & Integration,MA 222,Manjunath Krishnapur),Course(Class field theory: a course in arithmetic geometry,MA 356,Amalendu Krishna))
// (Course(Topics in Geometric Topology: Geometric structures,MA 355,Subhojoy Gupta),Course(Class field theory: a course in arithmetic geometry,MA 356,Amalendu Krishna))
// (Course(Algebraic Geometry,MA 308,Abhishek Banerjee),Course(Topics: Percolation,MA 390,Sanchayan Sen))
// (Course(Stochastic Finance,MA 263,Srikanth Iyer),Course(Algebraic Number Theory,MA 313,Soumya Das))
// (Course(Class field theory: a course in arithmetic geometry,MA 356,Amalendu Krishna),Course(Coxeter Groups,MA 386,R. Venkatesh))
// (Course(Topics in Geometric Topology: Geometric structures,MA 355,Subhojoy Gupta),Course(Coxeter Groups,MA 386,R. Venkatesh))
// (Course(Analysis III,MA 321,Swarnendu Sil),Course(Topics: Percolation,MA 390,Sanchayan Sen))"""
StudentChoices
  .strongClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res10: Vector[((String, String), String)] = Vector(
//   (("Introduction to Differentiable Manifolds", "Algebraic Geometry"), "Souptik Mudi"),
//   (("Measure & Integration", "Topics in Geometric Topology: Geometric structures"), "Sauditya Jaiswal"),
//   (("Class field theory: a course in arithmetic geometry", "Coxeter Groups"), "Nishu kumari")
// )
StudentChoices
  .weakClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res11: Vector[((String, String), String)] = Vector(
//   (("Algebraic Geometry", "Analysis III"), "Umang Bhat"),
//   (("Introduction to Differentiable Manifolds", "Topics: Percolation"), "Dhanus M Lal, Sauditya Jaiswal"),
//   (("Measure & Integration", "Coxeter Groups"), "Souptik Mudi, Sutanay Bhattacharya, Sarvagya Jain"),
//   (("Introduction to Differentiable Manifolds", "Analysis III"), "ARKA DAS"),
//   (
//     ("Introduction to Differentiable Manifolds", "Algebraic Geometry"),
//     "Sai Sanjeev Balakrishnan, Upamanyu Yaddanapudi, Souptik Mudi, Irish Debbarma, N Mohith Raju, Nikhesh Kumar, Kumar Sannidhya Shukla"
//   ),
//   (("Measure & Integration", "Topics in Geometric Topology: Geometric structures"), "Spandan Ghosh , Sauditya Jaiswal"),
//   (
//     ("Measure & Integration", "Class field theory: a course in arithmetic geometry"),
//     "Sai Sanjeev Balakrishnan, Upamanyu Yaddanapudi, Souptik Mudi, Irish Debbarma, Sutanay Bhattacharya, Kumar Sannidhya Shukla"
//   ),
//   (("Stochastic Finance", "Algebraic Number Theory"), "N Mohith Raju, Umang Bhat"),
//   (
//     ("Class field theory: a course in arithmetic geometry", "Coxeter Groups"),
//     "Souptik Mudi, Sutanay Bhattacharya, Nishu kumari"
//   )
// )
chosen.sorted.groupMap(_._2)(_._1)
// res12: Map[Timing, Vector[Course]] = HashMap(
//   TuTh(times = "11:30 - 1:00") -> Vector(
//     Course(name = "Stochastic Finance", code = "MA 263", instructor = "Srikanth Iyer"),
//     Course(name = "Algebraic Number Theory", code = "MA 313", instructor = "Soumya Das")
//   ),
//   MWF(times = "11:00 - 12:00") -> Vector(Course(name = "Algebra II", code = "MA 213", instructor = "Shaunak Deo")),
//   TuTh(times = "10:00 - 11:30") -> Vector(Course(name = "Topics in Complex Analysis", code = "MA 324", instructor = "Purvi Gupta")),
//   TuTh(times = "2:00 - 3:30") -> Vector(
//     Course(name = "Introduction to Differentiable Manifolds", code = "MA 235", instructor = "Ved Datar"),
//     Course(name = "Algebraic Geometry", code = "MA 308", instructor = "Abhishek Banerjee"),
//     Course(name = "Analysis III", code = "MA 321", instructor = "Swarnendu Sil"),
//     Course(name = "Topics: Percolation", code = "MA 390", instructor = "Sanchayan Sen")
//   ),
//   TuTh(times = "8:30 - 10:00") -> Vector(Course(name = "Algebraic Topology", code = "MA 332", instructor = "Siddhartha Gadgil")),
//   MWF(times = "10:00 - 11:00") -> Vector(
//     Course(name = "Topics in Harmonic Analysis II", code = "MA 322", instructor = "Thangavelu")
//   ),
//   TuTh(times = "3:30 - 5: 00") -> Vector(
//     Course(name = "Measure & Integration", code = "MA 222", instructor = "Manjunath Krishnapur"),
//     Course(name = "Topics in Geometric Topology: Geometric structures", code = "MA 355", instructor = "Subhojoy Gupta"),
//     Course(
//       name = "Class field theory: a course in arithmetic geometry",
//       code = "MA 356",
//       instructor = "Amalendu Krishna"
//     ),
//     Course(name = "Coxeter Groups", code = "MA 386", instructor = "R. Venkatesh")
//   ),
//   MWF(times = "9:00 - 10:00") -> Vector(Course(name = "Complex Analysis", code = "MA 224", instructor = "E. K. Narayanan")),
//   MWF(times = "2:00 - 3:00") -> Vector(
//     Course(name = "Ordinary Differential Equations", code = "MA 241", instructor = "Harish Seshadri")
//   )
// )
os.write.over(SavedData.dat / "schedule.tsv", chosen.tsv)