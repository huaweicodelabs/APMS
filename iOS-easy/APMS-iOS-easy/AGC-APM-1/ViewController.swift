/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        let requestButton = UIButton(frame: CGRect(x: 50, y: 80, width: 220, height: 50))
        requestButton.backgroundColor = UIColor.blue
        requestButton.setTitle("Send Network Request", for: .normal)
        requestButton.addTarget(self, action: #selector(makeRequest), for: .touchUpInside)
        self.view.addSubview(requestButton)

    }

    @objc func makeRequest() {
        let url = URL(string: "https://developer.huawei.com/consumer/cn/")!
        let session = URLSession.shared
        let task: URLSessionDataTask = session.dataTask(with: url) { data, response, error in
            let str = String(data: data!, encoding: .utf8)
            print(str)
        }
        task.resume()
    }

}

