import courses._
import BestChoice._

best 
// res0: Set[Schedule] = HashSet(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Measure & Integration", code = "MA 222", instructor = "Arka Mallick") -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Introduction to Tilings", code = "MA 237", instructor = "Subhojoy Gupta") -> TuTh(
//         times = "3:30 - 5: 00"
//       ),
//       Course(
//         name = "Introduction to Differentiable Manifolds",
//         code = "MA 235",
//         instructor = "Ved Datar"
//       ) -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Homogeneous Dynamics", code = "MA 346a", instructor = "Debanjan Nandy") -> MWF(times = "8:00 - 9:00"),
//       Course(
//         name = "Introduction to Statistical Learning<br/> with Applications",
//         code = "MA 267",
//         instructor = "Siva Athreya"
//       ) -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Complex Manifolds", code = "MA 345", instructor = "Purvi Gupta") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Fourier Analysis", code = "MA 326", instructor = "E.K.Narayanan") -> TuTh(times = "2:00 - 3:30"),
//       Course(
//         name = "Introduction to Graph Theory",
//         code = "MA 216",
//         instructor = "Vineeth Chintala/ Apoorva Khare"
//       ) -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Analysis III", code = "MA 321", instructor = "Swarnendu Sil") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Algebra II", code = "MA 213", instructor = "Shaunak Deo") -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Extremal Combinatorics",
//         code = "MA 376",
//         instructor = "Hiranya kishore Dey/Arvind Ayyer"
//       ) -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Complex Analysis", code = "MA 224", instructor = "E.K.Narayanan") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Proofs and Programs", code = "MA 208", instructor = "Siddhartha Gadgil") -> TuTh(
//         times = "8:30 - 10:00"
//       ),
//       Course(
//         name = "Representation Theory of Finite Groups",
//         code = "MA 220",
//         instructor = "Soumya Das"
//       ) -> TuTh(times = "11:30 - 1:00"),
//       Course(
//         name = "Topics in Probability and Stochastic Processes",
//         code = "MA 368",
//         instructor = "Biltu Dan/ Manjunath Krishnapur"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Algebraic Geometry I", code = "MA 310", instructor = "Abhishek Banerjee") -> TuTh(
// ...
best.size
// res1: Int = 6

bestSW
// res2: Set[Schedule] = HashSet(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Measure & Integration", code = "MA 222", instructor = "Arka Mallick") -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Introduction to Tilings", code = "MA 237", instructor = "Subhojoy Gupta") -> TuTh(
//         times = "3:30 - 5: 00"
//       ),
//       Course(
//         name = "Introduction to Differentiable Manifolds",
//         code = "MA 235",
//         instructor = "Ved Datar"
//       ) -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Homogeneous Dynamics", code = "MA 346a", instructor = "Debanjan Nandy") -> MWF(times = "8:00 - 9:00"),
//       Course(
//         name = "Introduction to Statistical Learning<br/> with Applications",
//         code = "MA 267",
//         instructor = "Siva Athreya"
//       ) -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Complex Manifolds", code = "MA 345", instructor = "Purvi Gupta") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Fourier Analysis", code = "MA 326", instructor = "E.K.Narayanan") -> TuTh(times = "2:00 - 3:30"),
//       Course(
//         name = "Introduction to Graph Theory",
//         code = "MA 216",
//         instructor = "Vineeth Chintala/ Apoorva Khare"
//       ) -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Analysis III", code = "MA 321", instructor = "Swarnendu Sil") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Algebra II", code = "MA 213", instructor = "Shaunak Deo") -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Extremal Combinatorics",
//         code = "MA 376",
//         instructor = "Hiranya kishore Dey/Arvind Ayyer"
//       ) -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Complex Analysis", code = "MA 224", instructor = "E.K.Narayanan") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Proofs and Programs", code = "MA 208", instructor = "Siddhartha Gadgil") -> MWF(
//         times = "10:00 - 11:00"
//       ),
//       Course(
//         name = "Representation Theory of Finite Groups",
//         code = "MA 220",
//         instructor = "Soumya Das"
//       ) -> TuTh(times = "11:30 - 1:00"),
//       Course(
//         name = "Topics in Probability and Stochastic Processes",
//         code = "MA 368",
//         instructor = "Biltu Dan/ Manjunath Krishnapur"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Algebraic Geometry I", code = "MA 310", instructor = "Abhishek Banerjee") -> TuTh(
// ...
bestSW.size
// res3: Int = 3
bestSW.map(_.clashes.size)
// res4: Set[Int] = HashSet(22, 23)
val commonClashes = bestSW.map(_.clashes).reduce(_ intersect _)
// commonClashes: Set[(Course, Course)] = HashSet(
//   (
//     Course(
//       name = "Introduction to Differentiable Manifolds",
//       code = "MA 235",
//       instructor = "Ved Datar"
//     ),
//     Course(name = "Algebraic Geometry I", code = "MA 310", instructor = "Abhishek Banerjee")
//   ),
//   (
//     Course(name = "Introduction to Tilings", code = "MA 237", instructor = "Subhojoy Gupta"),
//     Course(name = "Lie Groups and Lie Algebras", code = "MA 305", instructor = "Muna Naik")
//   ),
//   (
//     Course(name = "Algebraic Geometry I", code = "MA 310", instructor = "Abhishek Banerjee"),
//     Course(name = "Analysis III", code = "MA 321", instructor = "Swarnendu Sil")
//   ),
//   (
//     Course(name = "Algebra II", code = "MA 213", instructor = "Shaunak Deo"),
//     Course(
//       name = "Introduction to Statistical Learning<br/> with Applications",
//       code = "MA 267",
//       instructor = "Siva Athreya"
//     )
//   ),
//   (
//     Course(name = "Introduction to Tilings", code = "MA 237", instructor = "Subhojoy Gupta"),
//     Course(
//       name = "Topics in Probability and Stochastic Processes",
//       code = "MA 368",
//       instructor = "Biltu Dan/ Manjunath Krishnapur"
//     )
//   ),
//   (
//     Course(
//       name = "Topics in Gaussian Processes",
//       code = "MA 365",
//       instructor = "Manjunath Krishnapur"
//     ),
//     Course(
//       name = "Extremal Combinatorics",
//       code = "MA 376",
//       instructor = "Hiranya kishore Dey/Arvind Ayyer"
//     )
//   ),
//   (
//     Course(name = "Abstract Harmonic Analysis", code = "MA 372", instructor = "E.K.Narayanan"),
//     Course(
//       name = "Extremal Combinatorics",
// ...
commonClashes.size
// res5: Int = 22
val minClashSize = bestSW.map(_.clashes.size).min
// minClashSize: Int = 22
val minClashes = bestSW.filter(_.clashes.size == minClashSize).toVector
// minClashes: Vector[Schedule] = Vector(
//   Schedule(
//     sch = HashMap(
//       Course(name = "Measure & Integration", code = "MA 222", instructor = "Arka Mallick") -> MWF(times = "10:00 - 11:00"),
//       Course(name = "Introduction to Tilings", code = "MA 237", instructor = "Subhojoy Gupta") -> TuTh(
//         times = "3:30 - 5: 00"
//       ),
//       Course(
//         name = "Introduction to Differentiable Manifolds",
//         code = "MA 235",
//         instructor = "Ved Datar"
//       ) -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Homogeneous Dynamics", code = "MA 346a", instructor = "Debanjan Nandy") -> MWF(times = "8:00 - 9:00"),
//       Course(
//         name = "Introduction to Statistical Learning<br/> with Applications",
//         code = "MA 267",
//         instructor = "Siva Athreya"
//       ) -> MWF(times = "2:00 - 3:00"),
//       Course(name = "Complex Manifolds", code = "MA 345", instructor = "Purvi Gupta") -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Fourier Analysis", code = "MA 326", instructor = "E.K.Narayanan") -> TuTh(times = "2:00 - 3:30"),
//       Course(
//         name = "Introduction to Graph Theory",
//         code = "MA 216",
//         instructor = "Vineeth Chintala/ Apoorva Khare"
//       ) -> TuTh(times = "10:00 - 11:30"),
//       Course(name = "Analysis III", code = "MA 321", instructor = "Swarnendu Sil") -> TuTh(times = "2:00 - 3:30"),
//       Course(name = "Algebra II", code = "MA 213", instructor = "Shaunak Deo") -> MWF(times = "2:00 - 3:00"),
//       Course(
//         name = "Extremal Combinatorics",
//         code = "MA 376",
//         instructor = "Hiranya kishore Dey/Arvind Ayyer"
//       ) -> TuTh(times = "11:30 - 1:00"),
//       Course(name = "Complex Analysis", code = "MA 224", instructor = "E.K.Narayanan") -> MWF(times = "11:00 - 12:00"),
//       Course(name = "Proofs and Programs", code = "MA 208", instructor = "Siddhartha Gadgil") -> MWF(
//         times = "9:00 - 10:00"
//       ),
//       Course(
//         name = "Representation Theory of Finite Groups",
//         code = "MA 220",
//         instructor = "Soumya Das"
//       ) -> TuTh(times = "11:30 - 1:00"),
//       Course(
//         name = "Topics in Probability and Stochastic Processes",
//         code = "MA 368",
//         instructor = "Biltu Dan/ Manjunath Krishnapur"
//       ) -> TuTh(times = "3:30 - 5: 00"),
//       Course(name = "Algebraic Geometry I", code = "MA 310", instructor = "Abhishek Banerjee") -> TuTh(
// ...
minClashes.size
// res6: Int = 1
// minClashes(0).diff(minClashes(1))
val chosen = minClashes(0)
// chosen: Schedule = Schedule(
//   sch = HashMap(
//     Course(name = "Measure & Integration", code = "MA 222", instructor = "Arka Mallick") -> MWF(times = "10:00 - 11:00"),
//     Course(name = "Introduction to Tilings", code = "MA 237", instructor = "Subhojoy Gupta") -> TuTh(
//       times = "3:30 - 5: 00"
//     ),
//     Course(
//       name = "Introduction to Differentiable Manifolds",
//       code = "MA 235",
//       instructor = "Ved Datar"
//     ) -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Homogeneous Dynamics", code = "MA 346a", instructor = "Debanjan Nandy") -> MWF(times = "8:00 - 9:00"),
//     Course(
//       name = "Introduction to Statistical Learning<br/> with Applications",
//       code = "MA 267",
//       instructor = "Siva Athreya"
//     ) -> MWF(times = "2:00 - 3:00"),
//     Course(name = "Complex Manifolds", code = "MA 345", instructor = "Purvi Gupta") -> TuTh(times = "10:00 - 11:30"),
//     Course(name = "Fourier Analysis", code = "MA 326", instructor = "E.K.Narayanan") -> TuTh(times = "2:00 - 3:30"),
//     Course(
//       name = "Introduction to Graph Theory",
//       code = "MA 216",
//       instructor = "Vineeth Chintala/ Apoorva Khare"
//     ) -> TuTh(times = "10:00 - 11:30"),
//     Course(name = "Analysis III", code = "MA 321", instructor = "Swarnendu Sil") -> TuTh(times = "2:00 - 3:30"),
//     Course(name = "Algebra II", code = "MA 213", instructor = "Shaunak Deo") -> MWF(times = "2:00 - 3:00"),
//     Course(
//       name = "Extremal Combinatorics",
//       code = "MA 376",
//       instructor = "Hiranya kishore Dey/Arvind Ayyer"
//     ) -> TuTh(times = "11:30 - 1:00"),
//     Course(name = "Complex Analysis", code = "MA 224", instructor = "E.K.Narayanan") -> MWF(times = "11:00 - 12:00"),
//     Course(name = "Proofs and Programs", code = "MA 208", instructor = "Siddhartha Gadgil") -> MWF(
//       times = "9:00 - 10:00"
//     ),
//     Course(
//       name = "Representation Theory of Finite Groups",
//       code = "MA 220",
//       instructor = "Soumya Das"
//     ) -> TuTh(times = "11:30 - 1:00"),
//     Course(
//       name = "Topics in Probability and Stochastic Processes",
//       code = "MA 368",
//       instructor = "Biltu Dan/ Manjunath Krishnapur"
//     ) -> TuTh(times = "3:30 - 5: 00"),
//     Course(name = "Algebraic Geometry I", code = "MA 310", instructor = "Abhishek Banerjee") -> TuTh(
//       times = "2:00 - 3:30"
// ...
chosen.sch.size
// res7: Int = 24

chosen.tsv
// res8: String = """MA 208	Proofs and Programs	Siddhartha Gadgil	Mon, Wed, Fri	9:00 - 10:00
// MA 213	Algebra II	Shaunak Deo	Mon, Wed, Fri	2:00 - 3:00
// MA 216	Introduction to Graph Theory	Vineeth Chintala/ Apoorva Khare	Tue, Thu	10:00 - 11:30
// MA 218	Number Theory	Radhika Ganapathy	Tue, Thu	8:30 - 10:00
// MA 220	Representation Theory of Finite Groups	Soumya Das	Tue, Thu	11:30 - 1:00
// MA 222	Measure & Integration	Arka Mallick	Mon, Wed, Fri	10:00 - 11:00
// MA 224	Complex Analysis	E.K.Narayanan	Mon, Wed, Fri	11:00 - 12:00
// MA 235	Introduction to Differentiable Manifolds	Ved Datar	Tue, Thu	2:00 - 3:30
// MA 237	Introduction to Tilings	Subhojoy Gupta	Tue, Thu	3:30 - 5: 00
// MA 241	Ordinary Differential Equations	Vamsi Pingali	Mon, Wed, Fri	3:00 - 4:00
// MA 262	Introduction to Stochastic Processes	Sanchayan Sen	Tue, Thu	3:30 - 5: 00
// MA 267	Introduction to Statistical Learning<br/> with Applications	Siva Athreya	Mon, Wed, Fri	2:00 - 3:00
// MA 305	Lie Groups and Lie Algebras	Muna Naik	Tue, Thu	3:30 - 5: 00
// MA 310	Algebraic Geometry I	Abhishek Banerjee	Tue, Thu	2:00 - 3:30
// MA 321	Analysis III	Swarnendu Sil	Tue, Thu	2:00 - 3:30
// MA 326	Fourier Analysis	E.K.Narayanan	Tue, Thu	2:00 - 3:30
// MA 345	Complex Manifolds	Purvi Gupta	Tue, Thu	10:00 - 11:30
// MA 346	Ergodic Theory	Abhishek Khetan	Mon, Wed, Fri	3:00 - 4:00
// MA 346a	Homogeneous Dynamics	Debanjan Nandy	Mon, Wed, Fri	8:00 - 9:00
// MA 356	Class Field Theory	Mahesh Kakde	Tue, Thu	8:30 - 10:00
// MA 365	Topics in Gaussian Processes	Manjunath Krishnapur	Tue, Thu	11:30 - 1:00
// MA 368	Topics in Probability and Stochastic Processes	Biltu Dan/ Manjunath Krishnapur	Tue, Thu	3:30 - 5: 00
// MA 372	Abstract Harmonic Analysis	E.K.Narayanan	Tue, Thu	11:30 - 1:00
// MA 376	Extremal Combinatorics	Hiranya kishore Dey/Arvind Ayyer	Tue, Thu	11:30 - 1:00
// """
chosen.clashes.mkString("\n")
// res9: String = """(Course(Introduction to Differentiable Manifolds,MA 235,Ved Datar),Course(Algebraic Geometry I,MA 310,Abhishek Banerjee))
// (Course(Introduction to Tilings,MA 237,Subhojoy Gupta),Course(Lie Groups and Lie Algebras,MA 305,Muna Naik))
// (Course(Algebraic Geometry I,MA 310,Abhishek Banerjee),Course(Analysis III,MA 321,Swarnendu Sil))
// (Course(Algebra II,MA 213,Shaunak Deo),Course(Introduction to Statistical Learning<br/> with Applications,MA 267,Siva Athreya))
// (Course(Introduction to Tilings,MA 237,Subhojoy Gupta),Course(Topics in Probability and Stochastic Processes,MA 368,Biltu Dan/ Manjunath Krishnapur))
// (Course(Topics in Gaussian Processes,MA 365,Manjunath Krishnapur),Course(Extremal Combinatorics,MA 376,Hiranya kishore Dey/Arvind Ayyer))
// (Course(Abstract Harmonic Analysis,MA 372,E.K.Narayanan),Course(Extremal Combinatorics,MA 376,Hiranya kishore Dey/Arvind Ayyer))
// (Course(Ordinary Differential Equations,MA 241,Vamsi Pingali),Course(Ergodic Theory,MA 346,Abhishek Khetan))
// (Course(Introduction to Differentiable Manifolds,MA 235,Ved Datar),Course(Fourier Analysis,MA 326,E.K.Narayanan))
// (Course(Analysis III,MA 321,Swarnendu Sil),Course(Fourier Analysis,MA 326,E.K.Narayanan))
// (Course(Representation Theory of Finite Groups,MA 220,Soumya Das),Course(Topics in Gaussian Processes,MA 365,Manjunath Krishnapur))
// (Course(Number Theory,MA 218,Radhika Ganapathy),Course(Class Field Theory,MA 356,Mahesh Kakde))
// (Course(Introduction to Graph Theory,MA 216,Vineeth Chintala/ Apoorva Khare),Course(Complex Manifolds,MA 345,Purvi Gupta))
// (Course(Algebraic Geometry I,MA 310,Abhishek Banerjee),Course(Fourier Analysis,MA 326,E.K.Narayanan))
// (Course(Introduction to Stochastic Processes,MA 262,Sanchayan Sen),Course(Lie Groups and Lie Algebras,MA 305,Muna Naik))
// (Course(Introduction to Stochastic Processes,MA 262,Sanchayan Sen),Course(Topics in Probability and Stochastic Processes,MA 368,Biltu Dan/ Manjunath Krishnapur))
// (Course(Lie Groups and Lie Algebras,MA 305,Muna Naik),Course(Topics in Probability and Stochastic Processes,MA 368,Biltu Dan/ Manjunath Krishnapur))
// (Course(Representation Theory of Finite Groups,MA 220,Soumya Das),Course(Abstract Harmonic Analysis,MA 372,E.K.Narayanan))
// (Course(Introduction to Tilings,MA 237,Subhojoy Gupta),Course(Introduction to Stochastic Processes,MA 262,Sanchayan Sen))
// (Course(Representation Theory of Finite Groups,MA 220,Soumya Das),Course(Extremal Combinatorics,MA 376,Hiranya kishore Dey/Arvind Ayyer))
// (Course(Topics in Gaussian Processes,MA 365,Manjunath Krishnapur),Course(Abstract Harmonic Analysis,MA 372,E.K.Narayanan))
// (Course(Introduction to Differentiable Manifolds,MA 235,Ved Datar),Course(Analysis III,MA 321,Swarnendu Sil))"""
StudentChoices
  .strongClashes(chosen)
  .toVector
  .map {
    case (c, v) => (c._1.name, c._2.name) -> v.map(_.name).mkString(", ")
  }
  .filter(_._2.nonEmpty)
// res10: Vector[((String, String), String)] = Vector(
//   (("Introduction to Differentiable Manifolds", "Algebraic Geometry I"), "Maitreya Bhaduri"),
//   (("Representation Theory of Finite Groups", "Topics in Gaussian Processes"), "Sehaj Ganjoo"),
//   (("Number Theory", "Class Field Theory"), "Supriya Saha, Sehaj Ganjoo"),
//   (("Algebraic Geometry I", "Fourier Analysis"), "Kazi Aryan Amin"),
//   (("Introduction to Tilings", "Introduction to Stochastic Processes"), "Shubhanshu Prasad")
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
//     ("Introduction to Differentiable Manifolds", "Algebraic Geometry I"),
//     "Maitreya Bhaduri, Naveen Maurya, Varun kailash"
//   ),
//   (
//     ("Introduction to Tilings", "Topics in Probability and Stochastic Processes"),
//     "Siddhesh Patil, Shubhanshu Prasad, Muhammed Faheem A T"
//   ),
//   (("Abstract Harmonic Analysis", "Extremal Combinatorics"), "Saham Sil"),
//   (("Representation Theory of Finite Groups", "Topics in Gaussian Processes"), "Sehaj Ganjoo"),
//   (("Number Theory", "Class Field Theory"), "Supriya Saha, vyshnav v, Sachin Shukla, Sehaj Ganjoo"),
//   (("Introduction to Graph Theory", "Complex Manifolds"), "vyshnav v"),
//   (("Algebraic Geometry I", "Fourier Analysis"), "Kazi Aryan Amin, Biplab Das, vyshnav v"),
//   (
//     ("Introduction to Stochastic Processes", "Topics in Probability and Stochastic Processes"),
//     "Abhiram M, R K Shishir, Varivashya Poladi, Shubhanshu Prasad, Sehaj Ganjoo, Muhammed Faheem A T"
//   ),
//   (("Representation Theory of Finite Groups", "Abstract Harmonic Analysis"), "Saham Sil"),
//   (
//     ("Introduction to Tilings", "Introduction to Stochastic Processes"),
//     "Shyam Sundar M, Naveen Maurya, Shubhanshu Prasad, Raj Aniketh, Muhammed Faheem A T"
//   ),
//   (("Representation Theory of Finite Groups", "Extremal Combinatorics"), "Saham Sil")
// )
chosen.sorted.groupMap(_._2)(_._1)
// res12: Map[Timing, Vector[Course]] = HashMap(
//   TuTh(times = "11:30 - 1:00") -> Vector(
//     Course(
//       name = "Representation Theory of Finite Groups",
//       code = "MA 220",
//       instructor = "Soumya Das"
//     ),
//     Course(
//       name = "Topics in Gaussian Processes",
//       code = "MA 365",
//       instructor = "Manjunath Krishnapur"
//     ),
//     Course(name = "Abstract Harmonic Analysis", code = "MA 372", instructor = "E.K.Narayanan"),
//     Course(
//       name = "Extremal Combinatorics",
//       code = "MA 376",
//       instructor = "Hiranya kishore Dey/Arvind Ayyer"
//     )
//   ),
//   MWF(times = "11:00 - 12:00") -> Vector(
//     Course(name = "Complex Analysis", code = "MA 224", instructor = "E.K.Narayanan")
//   ),
//   TuTh(times = "10:00 - 11:30") -> Vector(
//     Course(
//       name = "Introduction to Graph Theory",
//       code = "MA 216",
//       instructor = "Vineeth Chintala/ Apoorva Khare"
//     ),
//     Course(name = "Complex Manifolds", code = "MA 345", instructor = "Purvi Gupta")
//   ),
//   TuTh(times = "2:00 - 3:30") -> Vector(
//     Course(
//       name = "Introduction to Differentiable Manifolds",
//       code = "MA 235",
//       instructor = "Ved Datar"
//     ),
//     Course(name = "Algebraic Geometry I", code = "MA 310", instructor = "Abhishek Banerjee"),
//     Course(name = "Analysis III", code = "MA 321", instructor = "Swarnendu Sil"),
//     Course(name = "Fourier Analysis", code = "MA 326", instructor = "E.K.Narayanan")
//   ),
//   TuTh(times = "8:30 - 10:00") -> Vector(
//     Course(name = "Number Theory", code = "MA 218", instructor = "Radhika Ganapathy"),
//     Course(name = "Class Field Theory", code = "MA 356", instructor = "Mahesh Kakde")
//   ),
//   MWF(times = "10:00 - 11:00") -> Vector(
//     Course(name = "Measure & Integration", code = "MA 222", instructor = "Arka Mallick")
//   ),
//   MWF(times = "3:00 - 4:00") -> Vector(
//     Course(name = "Ordinary Differential Equations", code = "MA 241", instructor = "Vamsi Pingali"),
// ...
os.write.over(SavedData.dat / "schedule.tsv", chosen.tsv)
chosen.core1TuTh
// res14: Int = 1
CourseData.core1
// res15: Vector[Course] = Vector(
//   Course(name = "Complex Analysis", code = "MA 224", instructor = "E.K.Narayanan"),
//   Course(
//     name = "Introduction to Differentiable Manifolds",
//     code = "MA 235",
//     instructor = "Ved Datar"
//   ),
//   Course(name = "Ordinary Differential Equations", code = "MA 241", instructor = "Vamsi Pingali")
// )
chosen.sch.filter{case (c, t) => CourseData.core1.contains(c) && t.isTuTh}
// res16: Map[Course, Timing] = HashMap(
//   Course(
//     name = "Introduction to Differentiable Manifolds",
//     code = "MA 235",
//     instructor = "Ved Datar"
//   ) -> TuTh(times = "2:00 - 3:30")
// )
chosen.sch.filter{case (c, t) => CourseData.core2.contains(c) && t.isTuTh}
// res17: Map[Course, Timing] = HashMap()
BestChoice.sch.worst
// res18: Int = 2
BestChoice.sch.numWorst
// res19: Int = 1