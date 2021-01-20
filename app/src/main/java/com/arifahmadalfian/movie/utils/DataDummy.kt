package com.arifahmadalfian.movie.utils

import com.arifahmadalfian.movie.data.source.local.entity.MovieEntity
import com.arifahmadalfian.movie.data.source.local.entity.TvshowEntity
import com.arifahmadalfian.movie.data.source.remote.response.MovieResponse
import com.arifahmadalfian.movie.data.source.remote.response.TvshowResponse

object DataDummy {

    fun getDummyMovie(): List<MovieEntity> {
        val movie = ArrayList<MovieEntity>()

        movie.add(MovieEntity(
                "a1",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "January 31, 2019",
                false,
                "https://image.tmdb.org/t/p/w500/xRWht48C2V8XNfzvPehyClOvDni.jpg"))

        movie.add(MovieEntity(
                "a2",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "December 7, 2018",
                false,
                "https://image.tmdb.org/t/p/w500/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg"))

        movie.add(MovieEntity(
                "a3",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "October 24, 2018",
                false,
                "https://image.tmdb.org/t/p/w500/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"))

        movie.add(MovieEntity(
                "a4",
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "February 7, 2019",
                false,
                "https://image.tmdb.org/t/p/w500/cO802woIgZsLbOWPUSsleobKyDp.jpg"))

        movie.add(MovieEntity(
                "a5",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "November 21, 2018",
                false,
                "https://image.tmdb.org/t/p/w500/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"))

        movie.add(MovieEntity(
                "a6",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "November 14, 2018",
                false,
                "https://image.tmdb.org/t/p/w500/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"))

        movie.add(MovieEntity(
                "a7",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "January 16, 2019",
                false,
                "https://image.tmdb.org/t/p/w500/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"))

        movie.add(MovieEntity(
                "a8",
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "November 27, 2018",
                false,
                "https://image.tmdb.org/t/p/w500/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg"))

        movie.add(MovieEntity(
                "a9",
                "Ralph Breaks the Internet ",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "November 20, 2018",
                false,
                "https://image.tmdb.org/t/p/w500/qEnH5meR381iMpmCumAIMswcQw2.jpg"))

        movie.add(
            MovieEntity(
                "a10",
                "Spider-Man: Into the Spider-Verse",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "December 6, 2018",
                false,
                "https://image.tmdb.org/t/p/w500/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg")
        )

        return movie
    }

    fun getDummyTvshow(): List<TvshowEntity> {
        val tvshow = ArrayList<TvshowEntity>()

        tvshow.add(
            TvshowEntity(
                        "b1",
                        "Arrow",
                        "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                        "October 10, 2012",
                        false,
                        "https://image.tmdb.org/t/p/w500/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg")
        )

        tvshow.add(
            TvshowEntity(
                        "b2",
                        "Doom Patrol",
                        "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                        "February 15, 2019",
                        false,
                        "https://image.tmdb.org/t/p/w500/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg")
        )

        tvshow.add(
            TvshowEntity(
                        "b3",
                        "Dragon Ball",
                        "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                        "February 26, 1986",
                        false,
                        "https://image.tmdb.org/t/p/w500/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg")
        )

        tvshow.add(
            TvshowEntity(
                        "b4",
                        "Fairy Tail",
                        "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                        "October 12, 2009",
                        false,
                        "https://image.tmdb.org/t/p/w500/703mVJP8UyP1b1hEJi6aTrf0MQ1.jpg")
        )

        tvshow.add(
            TvshowEntity(
                        "b5",
                        "Family Guy",
                        "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                        "January 31, 1999",
                        false,
                        "https://image.tmdb.org/t/p/w500/qlClTwL0GSGZUH7xwJU5PER5wnJ.jpg")
        )

        tvshow.add(
            TvshowEntity(
                        "b6",
                        "Marvel's Iron Fist",
                        "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                        "March 17, 2017",
                        false,
                        "https://image.tmdb.org/t/p/w500/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg")
        )

        tvshow.add(
            TvshowEntity(
                        "b7",
                        "The Flash",
                        "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                        "October 7, 2014",
                        false,
                        "https://image.tmdb.org/t/p/w500/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg")
        )

        tvshow.add(
            TvshowEntity(
                        "b8",
                        "Hanna",
                        "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                        "March 28, 2019",
                        false,
                        "https://image.tmdb.org/t/p/w500/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg")
        )

        tvshow.add(
            TvshowEntity(
                        "b9",
                        "Naruto Shipuddent",
                        "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                        "February 15, 2007",
                        false,
                        "https://image.tmdb.org/t/p/w500/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg")
        )

        tvshow.add(
            TvshowEntity(
                        "b10",
                        "Ncis",
                        "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                        "September 23, 2003",
                        false,
                        "https://image.tmdb.org/t/p/w500/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg")
        )

        return tvshow
    }

    fun generateRemoteDummyMovie(): List<MovieResponse> {
        val movie = ArrayList<MovieResponse>()

        movie.add(
            MovieResponse(
            "a1",
            "Alita: Battle Angel",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "January 31, 2019",
            false,
            "https://image.tmdb.org/t/p/w500/xRWht48C2V8XNfzvPehyClOvDni.jpg")
        )

        movie.add(MovieResponse(
            "a2",
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "December 7, 2018",
            false,
            "https://image.tmdb.org/t/p/w500/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg"))

        movie.add(MovieResponse(
            "a3",
            "Bohemian Rhapsody",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "October 24, 2018",
            false,
            "https://image.tmdb.org/t/p/w500/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"))

        movie.add(MovieResponse(
            "a4",
            "Cold Pursuit",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            "February 7, 2019",
            false,
            "https://image.tmdb.org/t/p/w500/cO802woIgZsLbOWPUSsleobKyDp.jpg"))

        movie.add(MovieResponse(
            "a5",
            "Creed II",
            "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
            "November 21, 2018",
            false,
            "https://image.tmdb.org/t/p/w500/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg"))

        movie.add(MovieResponse(
            "a6",
            "Fantastic Beasts: The Crimes of Grindelwald",
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            "November 14, 2018",
            false,
            "https://image.tmdb.org/t/p/w500/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"))

        movie.add(MovieResponse(
            "a7",
            "Glass",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "January 16, 2019",
            false,
            "https://image.tmdb.org/t/p/w500/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"))

        movie.add(MovieResponse(
            "a8",
            "Mortal Engines",
            "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
            "November 27, 2018",
            false,
            "https://image.tmdb.org/t/p/w500/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg"))

        movie.add(MovieResponse(
            "a9",
            "Ralph Breaks the Internet ",
            "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
            "November 20, 2018",
            false,
            "https://image.tmdb.org/t/p/w500/qEnH5meR381iMpmCumAIMswcQw2.jpg"))

        movie.add(MovieResponse(
            "a10",
            "Spider-Man: Into the Spider-Verse",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
            "December 6, 2018",
            false,
            "https://image.tmdb.org/t/p/w500/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg"))

        return movie
    }

    fun generateRemoteDummyTvshow(): List<TvshowResponse> {
        val tvshow = ArrayList<TvshowResponse>()

        tvshow.add(
            TvshowResponse(
                "b1",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "October 10, 2012",
                false,
                "https://image.tmdb.org/t/p/w500/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg")
        )

        tvshow.add(
            TvshowResponse(
                "b2",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "February 15, 2019",
                false,
                "https://image.tmdb.org/t/p/w500/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg")
        )

        tvshow.add(
            TvshowResponse(
                "b3",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "February 26, 1986",
                false,
                "https://image.tmdb.org/t/p/w500/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg")
        )

        tvshow.add(
            TvshowResponse(
                "b4",
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "October 12, 2009",
                false,
                "https://image.tmdb.org/t/p/w500/703mVJP8UyP1b1hEJi6aTrf0MQ1.jpg")
        )

        tvshow.add(
            TvshowResponse(
                "b5",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "January 31, 1999",
                false,
                "https://image.tmdb.org/t/p/w500/qlClTwL0GSGZUH7xwJU5PER5wnJ.jpg")
        )

        tvshow.add(
            TvshowResponse(
                "b6",
                "Marvel's Iron Fist",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "March 17, 2017",
                false,
                "https://image.tmdb.org/t/p/w500/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg")
        )

        tvshow.add(
            TvshowResponse(
                "b7",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "October 7, 2014",
                false,
                "https://image.tmdb.org/t/p/w500/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg")
        )

        tvshow.add(
            TvshowResponse(
                "b8",
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "March 28, 2019",
                false,
                "https://image.tmdb.org/t/p/w500/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg")
        )

        tvshow.add(
            TvshowResponse(
                "b9",
                "Naruto Shipuddent",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "February 15, 2007",
                false,
                "https://image.tmdb.org/t/p/w500/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg")
        )

        tvshow.add(
            TvshowResponse(
                "b10",
                "Ncis",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "September 23, 2003",
                false,
                "https://image.tmdb.org/t/p/w500/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg")
        )

        return tvshow
    }
}