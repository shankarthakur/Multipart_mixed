package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    request {

        method 'POST'
        url '/test'
        headers {
            contentType 'multipart/mixed;boundary=tdDxAL6NKwtv4cTz9PODsSS01qPJgY6mbZ'
        }
        multipart([

                info : named(
                        name: value(consumer(regex(nonEmpty())), producer('filename1')),
                        content: value(consumer(regex(nonEmpty())), producer(file('test.json')))),

                file2: named(
                        name: value(consumer(regex(nonEmpty())), producer('filename1')),
                        content: value(consumer(regex(nonEmpty())), producer(fileAsBytes('audio2.wav')))),
        ])
        response {
            status 202
        }
    }
}